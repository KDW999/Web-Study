//? react, 외부 라이브러리, 내부 파일 단위로 정렬
import React, { ChangeEvent, useEffect, useRef, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { useCookies } from 'react-cookie';

import { Box, Input, Divider, IconButton, Fab } from '@mui/material'
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import axios, { Axios, AxiosResponse } from 'axios';

import { useUserStore } from 'src/stores';
import { FILE_UPLOAD_URL, GET_BOARD_URL, PATCH_BOARD_URL, authorizationHeader, multipartHeader } from 'src/constants/api';
import ResponseDto from 'src/apis/response';
import { GetBoardResponseDto, PatchBoardResponseDto } from 'src/apis/response/board';
import { PatchBoardDto } from 'src/apis/request/board';

export default function BoardUpdateView() {

  //          HooK          //
  const navigator = useNavigate();

  const imageRef = useRef<HTMLInputElement | null>(null);

  const { boardNumber } = useParams();
  const { user } = useUserStore();

  const [cookies] = useCookies();
  const [boardTitle, setBoardTitle] = useState<string>('');
  const [boardContent, setBoardContent] = useState<string>('');
  const [boardImgUrl, setBoardImgUrl] = useState<string>('');

  const accessToken = cookies.accessToken;
  
  //          Event Handler          //
  //? 이미지 수정 버튼
  const onImageUploadButtonHandler = () => {
    if(!imageRef.current) return;
    imageRef.current.click();
  }
  //? 수정 기능
  const onUpdateButtonHandler = () => {
    //? 제목과 내용이 존재하는지 검증
    if (!boardTitle.trim() || !boardContent.trim()) {
      alert('모든 내용을 입력해주세요.');
      return;
    }
    
    patchBoard();
    //navigator('/myPage');
  }
  //? 이미지 수정
  // TODO : BoardDetailView, BoardUpdateView, MyPageHead에서 중복
  // TODO : Hook 또는 외부 함수로 변경
  const onImageUploadChangeHandler = (event : ChangeEvent<HTMLInputElement>) => {
    if(!event.target.files) return;
    const data = new FormData;
    data.append('file', event.target.files[0]);

    axios.post(FILE_UPLOAD_URL, data, multipartHeader())
    .then((response) => imageUploadResponseHandler(response))
    .catch((error) => imageUploadErrorHandler(error));
  }

  //? 글 수정
  const patchBoard = () => {

    const data : PatchBoardDto = {
      boardNumber : parseInt(boardNumber as string),
      boardTitle,
      boardContent,
      boardImgUrl
    }
    axios.patch(PATCH_BOARD_URL, data, authorizationHeader(accessToken))
    .then((response) => patchBoardResponseHandler(response))
    .catch((error) => patchBoardErrorHandler(error));
  }
  //? 글 조회
  const getBoard = () => {
    axios.get(GET_BOARD_URL(boardNumber as string))
    .then((response) => getBoardResponseHandler(response))
    .catch((error) => getBoardErrorHandler(error));
  }

  //          Response Handler          //
  const imageUploadResponseHandler = (response : AxiosResponse<any, any>) => {

    const imageUrl = response.data as string;
    if(!imageUrl) return;
    setBoardImgUrl(imageUrl);

  }
  const patchBoardResponseHandler = (response : AxiosResponse<any, any>) =>{
    const { result, message, data } = response.data as ResponseDto<PatchBoardResponseDto>
    if(!result || !data){
      alert(message);
      return;
    }

    // navigator('/myPage');
    navigator(`/board/detail/${boardNumber}`);
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

  //          Error Handler          //
  const getBoardErrorHandler = (error : any) => console.log(error.message);
  const patchBoardErrorHandler = (error : any) => console.log(error.message);
  const imageUploadErrorHandler = (error : any) => console.log(error.message);

  //          Use Effect          //
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
          
            <Box sx = {{ width : '100%'}}>
            <Input
            fullWidth
            disableUnderline
            multiline
            minRows={3}
            placeholder='본문을 작성해 주세요'
            sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%' }}
            value={boardContent}
            onChange={(event) => setBoardContent(event.target.value)} />
            <Box component = 'img' src ={boardImgUrl} sx= {{width : '100%'}}/>
            </Box>

          <IconButton onClick={() => onImageUploadButtonHandler()}>
            <ImageOutlinedIcon />
            <input ref = {imageRef} hidden type = 'file' onChange={(event) => onImageUploadChangeHandler(event)}/>
          </IconButton>
        </Box>
      </Box>
      <Fab
        sx={{ position: 'fixed', bottom: '200px', right: '248px', backgroundColor: 'rgba(0, 0, 0, 0.04)' }}
        onClick={() => onUpdateButtonHandler()}>
        <CreateIcon />
      </Fab>
    </Box>
  )
}
