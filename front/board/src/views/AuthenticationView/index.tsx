//? Box 컴포넌트 : mui에서 공간를 할당하는 모든 태그를 포함
//? Grid 컴포넌트 : mui에서 공간을 12등분하여 가로 사이즈에 따라 반응형 웹 개발을 지원
//? Typography 컴포넌트 : mui에서 글자를 출력하는 모든 태그 포함
import React, { useState } from 'react'
import { Box, Grid, Typography, Card } from '@mui/material'
import ContentPasteTwoToneIcon from '@mui/icons-material/ContentPasteTwoTone';

import LoginCardView from './LoginCardView';
import SignUpCardView from './SignUpCardView';

//# component return 안에서 조건문 처럼 논리 연산자와 삼항 연산자를 조건문처럼 사용할 때
//? 논리 연산자 (&&) : if문만 쓸 때
//? 삼항 연산자 (조건 ? 참 : 거짓) : if else / if - else if - else

export default function AuthenticationView() {

  //          Hook          //
  const [loginView, setLoginView] = useState<boolean>(true); // 상태변화를 위한 기준을 뭐로 해줄지 자기가 생각해서 고르기

  return (
    <Box sx={{ pr: "120px", pl: "120px" }}>
      <Grid container spacing={2}>
        <Grid item lg={7} sm={12}>
          <Box sx={{ display: 'flex', height: '100%', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
            <ContentPasteTwoToneIcon sx={{ fontSize: 42 }} />
            <Typography variant='h4'>환영합니다.</Typography>
            <Typography variant="h4">KDW's Board입니다.</Typography>
          </Box>
        </Grid>
        <Grid item lg={5} sm={12}>
          <Card sx={{
            height: '630px', mt: '100px', marginBottom: '80px',
            pt: '50px', pb: '30px', pl: '50px', pr: '50px'
          }}>
            {loginView ? (<LoginCardView setLoginView={setLoginView}/>) : (<SignUpCardView setLoginView={setLoginView}/>)}
          </Card>
        </Grid>
      </Grid>
    </Box>
  )
}
