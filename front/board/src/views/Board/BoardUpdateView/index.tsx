import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { BOARD_LIST } from 'src/mock';
import { useUserStore } from 'src/stores';
import { Box, Input, Divider, IconButton, Fab } from '@mui/material'
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import BoardWriteView from '../BoardWriteView';
import { GET_BOARD_URL } from 'src/constants/api';
import axios, { AxiosResponse } from 'axios';
import ResponseDto from 'src/apis/response';
import { GetBoardResponseDto } from 'src/apis/response/board';
import { useCookies } from 'react-cookie';

export default function BoardUpdateView() {

  const [cookies] = useCookies();
  const { boardNumber } = useParams();
  const navigator = useNavigate();
  const { user } = useUserStore();
  const [boardTitle, setBoardTitle] = useState<string>('');
  const [boardContent, setBoardContent] = useState<string>('');
  const [boardImgUrl, setBoardImgUrl] = useState<string>('');

  const accessToken = cookies.accessToken;

  //? 글 조회
  const getBoard = () => {
    axios.get(GET_BOARD_URL(boardNumber as string))
    .then((response) => getBoardResponseHandler(response))
    .catch((error) => getBoardErrorHandler(error));
  }

  const getBoardResponseHandler = (response : AxiosResponse<any, any>) => {

    const { result, message, data } = response.data as ResponseDto<GetBoardResponseDto>;
    if(!result || !data){
      alert(message);
      navigator('/');
      return;
    }

    const { boardTitle, boardContent, boardImgUrl, writerEmail } = data.board;

    if(writerEmail !== user?.email){
      alert('권한 없음')
      navigator('/');
      return;
    }
    setBoardTitle(boardTitle);
    setBoardContent(boardContent);
    if(boardImgUrl) setBoardImgUrl(boardImgUrl);

  }

  const getBoardErrorHandler = (error : any) => console.log(error.message);

  const onUpdateHandler = () => {
    //? 제목과 내용이 존재하는지 검증
    if (!boardTitle.trim() || !boardContent.trim()) {
      alert('모든 내용을 입력해주세요.');
      return;
    }
    
    navigator('/myPage');
  }
  useEffect(() => {
    //? 정상적이지 않은 경로로 접근을 시도했을 때
    //? main 화면으로 돌려보냄
    if (!boardNumber) {
      navigator('/');
      return;
    }

    //? 현재 로그인되어 있는지 검증
    if (!accessToken) {
      navigator('/auth');
      return
    }

    getBoard();

    //? pathVariable로 전달받은 boardNumber에 해당하는 board 데이터를 검색해 옴
    //? const board = BOARD_LIST.find((item) => item.boardNumber === parseInt(boardNumber));
    //? 검색결과가 존재하지 않으면
    //? main 화면으로 돌려보냄
    // if (!board) {
    //   navigator('/');
    //   return;
    // }

    //? 검색된 board의 작성자가 로그인한 user와 일치하는지 검증
    // if (board.writerNickname !== user?.nickname) {
    //   navigator('/');
    //   return
    // }

    // setBoardTitle(board.boardTitle);
    // setBoardContent(board.boardContent);
    
  }, [])

  //? 일반적으로 수정 페이지는 작성 페이지와 거의 똑같음
  return (
    <Box sx={{ p: '0px 198px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
      <Box sx={{ p: '100px 24px', backgroundColor: '#ffffff' }}>
        <Input
          fullWidth
          disableUnderline
          placeholder='제목을 입력하세요.'
          sx={{ fontSize: '32px', fontWeight: 500 }}
          value={boardTitle}
          onChange={(event) => setBoardTitle(event.target.value)} />
        <Divider sx={{ m: '40px 0px' }} />
        <Box sx={{ display: 'flex', alignItems: 'start' }}>
          <Input
            fullWidth
            disableUnderline
            multiline
            minRows={20}
            placeholder='본문을 작성해 주세요'
            sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%' }}
            value={boardContent}
            onChange={(event) => setBoardContent(event.target.value)} />
          <IconButton>
            <ImageOutlinedIcon />
          </IconButton>
        </Box>
      </Box>
      <Fab
        sx={{ position: 'fixed', bottom: '200px', right: '248px', backgroundColor: 'rgba(0, 0, 0, 0.04)' }}
        onClick={onUpdateHandler}>
        <CreateIcon />
      </Fab>
    </Box>
  )
}
