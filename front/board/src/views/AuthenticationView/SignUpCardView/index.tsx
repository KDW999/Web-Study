import React, { Dispatch, SetStateAction, useState } from 'react'
import {
  Box, Grid, Typography, Card, TextField, FormControl, InputLabel, Input, InputAdornment,
  IconButton,
  Button
} from '@mui/material'
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import Visibility from '@mui/icons-material/Visibility';
import { useSignUpStore } from 'src/stores'; // export는 중괄호 써서 가져와라
import KeyboardDoubleArrowRightIcon from '@mui/icons-material/KeyboardDoubleArrowRight';
import axios from 'axios';
import { SignUpDto } from 'src/apis/request/auth';
import  ResponseDto from 'src/apis/response';
import { SignUpresponseDto } from 'src/apis/response/auth';
import { SIGN_UP_URL } from 'src/constants/api';

function FirstPage() {

  const { email, password, passwordCheck} = useSignUpStore();
  const { setEmail, setPassword, setPasswordCheck } = useSignUpStore();
  const [showPassword, setShowPassword] = useState<boolean>(false);
  const [showPasswordCheck, setShowPasswordCheck] = useState<boolean>(false);
  return (
    <Box>
      {/*현재 상태 보여주는 용도 */email}  
      <TextField
        sx={{ mt: '40px' }}
        fullWidth label='이메일 주소*'
        variant='standard'
        
        // value = {'d'} 하면 input에 d가 고정
        // value = {email} 하면 상태에 email의 값이 남아있다.
        // 보여지고 말고의 차이?
        value = {email} // onChange는 둘이 한 세트라 생각하면 편함 
        onChange={(event) => setEmail(event.target.value)} // 현재 입력된 텍스트를 읽어오기
        /> 

      <FormControl fullWidth variant="standard" sx={{ mt: '40px' }}>
        <InputLabel htmlFor="standard-adornment-password">비밀번호*</InputLabel>
        <Input
          type={showPassword ? 'text' : 'password'}
          endAdornment={
            <InputAdornment position="end">
              <IconButton
                onClick={() => setShowPassword(!showPassword)}>
                {showPassword ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
          value = {password}
          onChange={(event) => setPassword(event.target.value)}
        />
      </FormControl>
      <FormControl fullWidth variant="standard" sx={{ mt: '40px' }}>
        <InputLabel htmlFor="standard-adornment-password">비밀번호 확인*</InputLabel>
        <Input
          type={showPasswordCheck ? 'text' : 'password'}
          endAdornment={
            <InputAdornment position="end">
              <IconButton
                onClick={() => setShowPasswordCheck(!showPasswordCheck)}
              >
                {showPasswordCheck ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
          value = {passwordCheck}
          onChange={(event) => setPasswordCheck(event.target.value)}
        />
      </FormControl>
    </Box>
  )
}

function SecondPage() {
  const{nickname, telNumber, address, addressDetail} = useSignUpStore();
  const{setNickname, setTelNumber, setAddress, setAddressDetail} = useSignUpStore();

  return (
    <Box>
      <TextField 
      sx = {{mt : '40px'}} 
      fullWidth label = "닉네임*" 
      variant = "standard" 
      value = {nickname} 
      onChange = {(event) => setNickname(event.target.value)}/>
      <TextField 
      sx = {{mt : '40px'}} 
      fullWidth label = "휴대폰 번호*" 
      variant= 'standard' 
      value = {telNumber} 
      onChange = {(event) => setTelNumber(event.target.value)}/>

      <FormControl fullWidth variant='standard' sx = {{mt : '40px'}}>
        <InputLabel>주소*</InputLabel>
        <Input type = 'text' endAdornment = {
          <InputAdornment position='end'>
           <IconButton>
            <KeyboardDoubleArrowRightIcon/>
           </IconButton>
          </InputAdornment>}
          value = {address} 
          onChange = {(event) => setAddress(event.target.value)}
          />
      </FormControl>

      <TextField 
      sx = {{mt : '40px'}} 
      fullWidth label = "상세 주소*" 
      variant='standard'
      value = {addressDetail} 
      onChange = {(event) => setAddressDetail(event.target.value)}/>
    </Box>
  )
}

interface Props {
  setLoginView: Dispatch<SetStateAction<boolean>>;
}
export default function SignUpCardView({ setLoginView }: Props) {

  const { email, password, passwordCheck } = useSignUpStore();
  const [page, setPage] = useState<number>(1);
  const { nickname, address, addressDetail, telNumber} = useSignUpStore();


  const onNextButtonHandler = () => {
    //todo : 이메일 / 비밀번호 / 비밀번호 확인 검증
    //? 해당 문자열 변수가 빈값인지 확인
    //? 1. 해당 변수 == '';
    //? 2. 해당 변수 길이 == 0;
    if (!email || !password || !passwordCheck) { // 스크립트에선 !으로 값이 비었는지 검사가능 / 자바에선 이러면 안됨
      alert('모든 값을 입력하세요.');
      return;
    }
    if (password !== passwordCheck) {
      alert('비밀번호가 다릅니다.');
      return
    }

    //todo : 검증이 실패하면 return
    //todo : 검증이 성공하면 page 변경
    setPage(2);
  };

  const onSignUpHandler = () => {
    if(!email || !password || !passwordCheck){
      alert('모든 값을 입력하세요.');
      setPage(1);
      return;
    }
    if(!nickname || !telNumber || !address || !addressDetail){
      alert('모든 값을 입력하세요.');
      return;
    }
    if(password !== passwordCheck){
      alert('비밀번호가 서로 다릅니다.');
      setPage(1);
      return;
    }

    const data : SignUpDto = { email, password, nickname, address : `${address} ${addressDetail}` , telNumber } // passwordCheck,
    
    console.log('axios 이전☆')

    // js는 비동기 처리 → 작업 중 대기 시간을 기다리지 않고 따로 작동시켜놓고 다음 작업으로 넘어감
    // 통신을 위한 axios, post : backend의 주소 담기, then : 작업 처리, catch : 에러 처리
    //? 1. 비동기 처리 (then 방법)
    axios.post(SIGN_UP_URL, data)
    .then((response) => {
      const { result, message, data } = response.data as ResponseDto<SignUpresponseDto>; 

      if(result) setLoginView(true);
      else alert(message);
      
    })
    .catch((error) => { 
      console.log(error.response.status);
    });

    // await : 작업이 끝날 때 까지 기다리기 → 동기 처리
    // 호출되는 함수의 매개변수 앞에 async 붙여서 동기처리 해줘야됨
    // 도중에 에러 터지면 다음 작업 실행하지 않음
    // const response = await axios.post("http://localhost:4040/auth/sign-up", data);

    console.log('axios 이후★')
  }

  return (
    <Box display='flex' sx={{ height: '100%', flexDirection: 'column', justifyContent: 'space-between' }} >
      <Box>
        <Box display='flex' justifyContent='space-between' >
          <Typography variant='h4' fontWeight='900'>회원가입</Typography>
          <Typography variant='h4' fontWeight='900'>{page}/2</Typography>
        </Box>
        {page === 1 ? (<FirstPage />) : (<SecondPage />)}
      </Box>

      <Box>
        {page === 1 && (<Button fullWidth variant='contained' size='large' sx={{ mb: '20px' }} onClick = {onNextButtonHandler}>다음 단계</Button>)}
        {page === 2 && (<Button fullWidth variant='contained' size='large' sx={{ mb: '20px' }} onClick = {onSignUpHandler}>회원가입</Button>)}
        <Typography textAlign='center'>이미 계정이 있으신가요?
          <Typography component='span' fontWeight='900' onClick={() => setLoginView(true)}>로그인</Typography>
        </Typography>
      </Box>
    </Box>
  )
}
