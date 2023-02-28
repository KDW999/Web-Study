import React, { useState } from 'react'
import { Box, Input, Divider, IconButton, Fab } from '@mui/material'
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import { useNavigate } from 'react-router-dom';

export default function BoardWriteView() {

    const [boardTitle, setBoardTitle] = useState<string>('');
    const [boardContent, setBoardContent] = useState<string>('');

    const navigator = useNavigate();

    const onWriteHandler = () => {
      //? 제목 및 내용 검증 (값이 존재하는지)
      if(!boardTitle.trim() || !boardContent.trim()){
        alert('모든 내용을 입력해주세요.')
        return;
      }
      //@ DB가 존재한다면 작성
      //# User table
      //^ userEmail VARCHAR(45) PK

      //# Board table
      //^ boardNumber INT AI PK
      //^ boardTitle TEXT NOT NULL
      //^ boardContent TEXT NOT NULL
      //^ writeDate DATETIME NOT NULL
      //^ writerEmail VARCHAR(45) FK NOT NULL
      //^ likeCount INT DEFAULT 0
      //^ commentCount INT DEFAULT 0
      //^ viewCount INT DEFAULT 0

      //? INSERT INTO Board(boardTitle, boardContent, writeDate, writerEmail) 
      //? VALUES (?, ?, now(), ?);

      //? BackEnd로 boardTitle, boardContent, writerEmail만 넘겨주면 됨
      navigator('/myPage');
    }

    return (
        <Box sx={{ p: '0px 198px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
            <Box sx={{ p: '100px 24px', backgroundColor: '#ffffff' }}>
                <Input
                    fullWidth 
                    disableUnderline
                    placeholder='제목을 입력하세요.'
                    sx={{ fontSize: '32px', fontWeight: 500 }} 
                    onChange = {(event) => setBoardTitle(event.target.value)}/>
                <Divider sx={{ m: '40px 0px' }} />
                <Box sx = {{ display : 'flex', alignItems : 'start'}}>
                   <Input 
                    fullWidth 
                    disableUnderline
                    multiline
                    minRows={20}
                    placeholder = '본문을 작성해 주세요'
                    sx = {{ fontSize : '18px', fontWeight : 500, lineHeight : '150%'}}
                    onChange = {(event) => setBoardContent(event.target.value)}/>
                   <IconButton>
                     <ImageOutlinedIcon/>
                   </IconButton>
                </Box>
            </Box>
            <Fab 
            sx = {{ position : 'fixed', bottom : '200px', right : '248px', backgroundColor : 'rgba(0, 0, 0, 0.04)'}}
            onClick = {onWriteHandler}>
             <CreateIcon/>
            </Fab>
        </Box>
    )
}
