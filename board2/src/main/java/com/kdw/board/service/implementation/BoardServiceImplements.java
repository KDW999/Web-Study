package com.kdw.board.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdw.board.common.constant.ResponseMessage;
import com.kdw.board.dto.request.board.LikeDto;
import com.kdw.board.dto.request.board.PatchBoardDto;
import com.kdw.board.dto.request.board.PostCommentDto;
import com.kdw.board.dto.request.board.PostboardDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.board.DeleteBoardResponseDto;
import com.kdw.board.dto.response.board.GetBoardResponseDto;
import com.kdw.board.dto.response.board.GetListResponseDto;
import com.kdw.board.dto.response.board.GetMyListResponseDto;
import com.kdw.board.dto.response.board.GetSearchListResponseDto;
import com.kdw.board.dto.response.board.GetTop15RelatedSearchWordResponseDto;
import com.kdw.board.dto.response.board.GetTop15SearchWordResponseDto;
import com.kdw.board.dto.response.board.GetTop3ListResponseDto;
import com.kdw.board.dto.response.board.LikeResponseDto;
import com.kdw.board.dto.response.board.PatchBoardResponseDto;
import com.kdw.board.dto.response.board.PostBoardResponseDto;
import com.kdw.board.dto.response.board.PostCommentResponseDto;
import com.kdw.board.entity.BoardEntity;
import com.kdw.board.entity.CommentEntity;
import com.kdw.board.entity.LikyEntity;
import com.kdw.board.entity.RelatedSearchWordEntity;
import com.kdw.board.entity.SearchWordLogEntity;
import com.kdw.board.entity.UserEntity;
import com.kdw.board.entity.resultSet.RelatedSearchWordResultSet;
import com.kdw.board.entity.resultSet.SearchWordResultSet;
import com.kdw.board.repository.BoardRepository;
import com.kdw.board.repository.CommentRepository;
import com.kdw.board.repository.LikyRepository;
import com.kdw.board.repository.RelatedSearchWordRepository;
import com.kdw.board.repository.SearchWordLogRepository;
import com.kdw.board.repository.UserRepository;
import com.kdw.board.service.BoardService;

@Service
public class BoardServiceImplements implements BoardService {
    
    @Autowired private BoardRepository boardRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private LikyRepository likyRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private SearchWordLogRepository searchWordLogRepository;
    @Autowired private RelatedSearchWordRepository relatedSearchWordRepository;

    // 글 생성
    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostboardDto dto){
       
        PostBoardResponseDto data = null;

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = new BoardEntity(userEntity, dto);
            boardRepository.save(boardEntity);

            data = new PostBoardResponseDto(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    // 좋아요 가져오기
    public ResponseDto<LikeResponseDto> like(String email, LikeDto dto){

        LikeResponseDto data = null;
        int boardNumber = dto.getBoardNumber();

        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            LikyEntity likyEntity = likyRepository.findByUserEmailAndBoardNumber(email, boardNumber);
            if(likyEntity == null){
                likyEntity = new LikyEntity(userEntity, boardNumber);
                likyRepository.save(likyEntity);
                boardEntity.increaseLikeCount();
            }
            else{
                likyRepository.delete(likyEntity);
                boardEntity.decreaseLikeCount();
            }

            boardRepository.save(boardEntity);

            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
            List<LikyEntity> likeList = likyRepository.findByBoardNumber(boardNumber);

            data = new LikeResponseDto(boardEntity, likeList, commentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 댓글
    public ResponseDto<PostCommentResponseDto> postComment(String email, PostCommentDto dto){
        
        PostCommentResponseDto data = null;    

        int boardNumber = dto.getBoardNumber();

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            CommentEntity commentEntity = new CommentEntity(userEntity, dto);
            commentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
            boardRepository.save(boardEntity);

            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
            List<LikyEntity> likeList = likyRepository.findByBoardNumber(boardNumber);

            data = new PostCommentResponseDto(boardEntity, likeList, commentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }


    // 글 조회
    public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber){
        
        GetBoardResponseDto data = null;

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            List<LikyEntity> likyList = likyRepository.findByBoardNumber(boardNumber);
            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);

            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);

            data = new GetBoardResponseDto(boardEntity, likyList, commentList);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 글 목록 
    public ResponseDto<List<GetListResponseDto>> getList(){

        List<GetListResponseDto> data = null;

        try {
            
            List<BoardEntity> boardEntityList = boardRepository.findByOrderByBoardWriteDatetimeDesc();
            data = GetListResponseDto.copyList(boardEntityList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 내 글 목록
    public ResponseDto<List<GetMyListResponseDto>> getMyList(String email){

        List<GetMyListResponseDto> data = null;

        try {
            
            List<BoardEntity> boardList = boardRepository.findByWriterEmailOrderByBoardWriteDatetimeDesc(email);
            data = GetMyListResponseDto.copyList(boardList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 글 검색
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(String searchWord, String previousSearchWord){

        List<GetSearchListResponseDto> data = null;
        
        try {

            SearchWordLogEntity searchWordLogEntity = new SearchWordLogEntity(searchWord);
            searchWordLogRepository.save(searchWordLogEntity);

            if(previousSearchWord != null && !previousSearchWord.isBlank()){
                RelatedSearchWordEntity relatedSearchWordEntity = new RelatedSearchWordEntity(searchWord, previousSearchWord);
                relatedSearchWordRepository.save(relatedSearchWordEntity);
            }

            List<BoardEntity> boardList = boardRepository.findByBoardTitleContainsOrBoardContentContainsOrderByBoardWriteDatetimeDesc(searchWord, searchWord);
            
            data = GetSearchListResponseDto.copyList(boardList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
    // Top3
    
    // Top15
    public ResponseDto<GetTop15SearchWordResponseDto> getTop15SearchWord(){

        GetTop15SearchWordResponseDto data = null;

        try {

            List<SearchWordResultSet> searchWordList = searchWordLogRepository.findTop15();
            data = GetTop15SearchWordResponseDto.copyList(searchWordList);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
    // 연관 검색어
    public ResponseDto<GetTop15RelatedSearchWordResponseDto> getTop15RelatedSearchWord(String searchWord) {
        GetTop15RelatedSearchWordResponseDto data = null;

        try {

            List<RelatedSearchWordResultSet> relatedSearchWordList = relatedSearchWordRepository.findTop15(searchWord);
            data = GetTop15RelatedSearchWordResponseDto.copyList(relatedSearchWordList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 글 수정
    public ResponseDto<PatchBoardResponseDto> patchBoard(String email, PatchBoardDto dto){

        PatchBoardResponseDto data = null;

        int boardNumber = dto.getBoardNumber();

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            boolean isEqualWriter = email.equals(boardEntity.getWriterEmail());
            if(!isEqualWriter) return ResponseDto.setFailed(ResponseMessage.NOT_PERMISSION);

            boardEntity.patch(dto);
            boardRepository.save(boardEntity);

            List<LikyEntity> likyList = likyRepository.findByBoardNumber(boardNumber);
            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);

            data = new PatchBoardResponseDto(boardEntity, likyList, commentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 글 삭제
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(String email, int boardNumber){

        DeleteBoardResponseDto data = null;

        try {
            
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            boolean isEqualWriter = email.equals(boardEntity.getWriterEmail());
            if(!isEqualWriter) return ResponseDto.setFailed(ResponseMessage.NOT_PERMISSION);

            commentRepository.deleteByBoardNumber(boardNumber);
            likyRepository.deleteByBoardNumber(boardNumber);

            boardRepository.delete(boardEntity);
            data = new DeleteBoardResponseDto(true);

         } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
    public ResponseDto<List<GetTop3ListResponseDto>> getTop3List(){

        List<GetTop3ListResponseDto> data = null;

        try {
            List<BoardEntity> boardList = boardRepository.findTop3ByOrderByLikeCountDesc();
            data = GetTop3ListResponseDto.copyList(boardList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
