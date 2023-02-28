import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { BOARD_LIST } from 'src/mock';
import { useUserStore } from 'src/stores';
import { Box, Input, Divider, IconButton, Fab } from '@mui/material'
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import BoardWriteView from '../BoardWriteView';

export default function BoardUpdateView() {

  const { boardNumber } = useParams();
  const navigator = useNavigate();
  const { user } = useUserStore();
  const [boardTitle, setBoardTitle] = useState<string>('');
  const [boardCotent, setBoardContent] = useState<string>('');

  const onUpdateHandler = () => {
    //? 제목과 내용이 존재하는지 검증
    if (!boardTitle.trim() || !boardCotent.trim()) {
      alert('모든 내용을 입력해주세요.');
      return;
    }
    //? 업데이트 기능 수행

    //@ DB
    //# Board table
    //^ boardNumber INT AI PK
    //^ boardTitle TEXT NOT NULL
    //^ boardContent TEXT NOT NULL
    //^ writeDate DATETIME NOT NULL
    //^ writerEmail VARCHAR(45) FK NOT NULL
    //^ likeCount INT DEFAULT 0
    //^ commentCount INT DEFAULT 0
    //^ viewCount INT DEFAULT 0

    //? User 테이블에서 해당 유저가 있는지 확인
    //? Board 테이블에서 해당 board 레코드가 있는지 확인
    //? Board 레코드의 작성자가 userEmail과 동일한지 확인
    //? UPDATE Board SET boardTitle = ?, boardContent = ? WHERE boardNumber = ?

    //? Back End로 boardTitle, boardContent, boardNumber를 넘겨주면 됨

    navigator('/myPage');
  }
  useEffect(() => {
    //? 정상적이지 않은 경로로 접근을 시도했을 때
    //? main 화면으로 돌려보냄
    if (!boardNumber) {
      navigator('/');
      return;
    }

    //? pathVariable로 전달받은 boardNumber에 해당하는 board 데이터를 검색해 옴
    const board = BOARD_LIST.find((item) => item.boardNumber === parseInt(boardNumber));
    //? 검색결과가 존재하지 않으면
    //? main 화면으로 돌려보냄
    if (!board) {
      navigator('/');
      return;
    }
    //? 현재 로그인되어 있는지 검증
    if (!user) {
      navigator('/auth');
      return
    }

    //? 검색된 board의 작성자가 로그인한 user와 일치하는지 검증
    if (board.writerNickname !== user?.nickname) {
      navigator('/');
      return
    }

    setBoardTitle(board.boardTitle);
    setBoardContent(board.boardContent);
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
            value={boardCotent}
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
