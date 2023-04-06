import React, { ChangeEvent, Dispatch, SetStateAction, useState } from 'react'

import axios, { AxiosResponse } from 'axios';
import {
  Box, Grid, Typography, Card, TextField, FormControl, InputLabel, Input, InputAdornment,
  IconButton,
  Button,
  FormHelperText,
  Checkbox
} from '@mui/material'
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import Visibility from '@mui/icons-material/Visibility';
import KeyboardDoubleArrowRightIcon from '@mui/icons-material/KeyboardDoubleArrowRight';

import { useSignUpStore } from 'src/stores'; // export는 중괄호 써서 가져와라
import { SignUpDto } from 'src/apis/request/auth';
import  ResponseDto from 'src/apis/response';
import { SignUpresponseDto } from 'src/apis/response/auth';
import { POST_VALIDATE_EMAIL, SIGN_UP_URL } from 'src/constants/api';
import { ValidateEmailResponseDto } from 'src/apis/response/user';
import { ValidateEmailDto } from 'src/apis/request/user';

//          Component          //

interface FirstPageProps {
  signUpError : boolean;
}
function FirstPage({signUpError} : FirstPageProps) {

  //          Hook          //
  const { email, password, passwordCheck} = useSignUpStore();
  const { setEmail, setPassword, setPasswordCheck } = useSignUpStore();

  const [emailMessage, setEmailMessage] = useState<string>('');
  const [passwordMessage, setPasswordMessage] = useState<string>('');
  const [passwordCheckMessage, setPasswordCheckMessage] = useState<string>('');
  const [emailValidateMessage, setEmailValidateMessage] = useState<string>('');

  const [showPassword, setShowPassword] = useState<boolean>(false);
  const [showPasswordCheck, setShowPasswordCheck] = useState<boolean>(false);

  //? 정규식 사용
  const emailValidator = /^[A-Za-z0-9]([-.]?[A-Za-z0-9])*@[A-Za-z0-9]([-.]?[A-Za-z0-9])*\.[A-Za-z0-9]{2,3}$/ //? 이렇게 적으면 A~Z, a~z 0~9까지만 문자로 지정해줄 수 있다.
  //? /^ : 정규식의 시작, $/ : 정규식의 종료 
  //? * : 어떠한 길이의 문자가 와도된다.
  //? @ : 해당 위치에 @가 있어야 한다.
  //? -. : 해당 위치에 -.이 있어야 한다.
  //? {2,3} : 2~3 글자여야 한다.
  const passwordValidator = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!?_]).{8,20}$/

  //          Event Handler          //
  const onEmailChangeHandler = (event : ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    const value = event.target.value;
    const isMatched = emailValidator.test(value);
    if(isMatched) setEmailMessage('');
    else setEmailMessage('이메일 주소 포맷이 맞지 않습니다.');
    setEmail(value);
  }
  
  const emailValidateHandler = () => {
    if(emailMessage) return;
    const data : ValidateEmailDto = { email }

    axios.post(POST_VALIDATE_EMAIL, data)
    .then((response) => emailValidateResponseHandler(response))
    .catch((error) => emailValidateErrorHandler(error));
  }

  const onPasswordChangeHandler = (event : ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    const value = event.target.value;
    const isMatched = passwordValidator.test(value);
    if(isMatched) setPasswordMessage('');
    else setPasswordMessage('영 대소문자 + 숫자 + 특수문자(!?_)를 포함한 8-20자');
    setPassword(value);
  }

  const onPasswordCheckChangeHandler = (event : ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    const value = event?.target.value;
    const isMatched = password === value;
    if(isMatched) setPasswordCheckMessage('');
    else setPasswordCheckMessage('비밀번호가 서로 일치하지 않습니다.');
    setPasswordCheck(value);
  }

  //          Response Handler          //
  const emailValidateResponseHandler = (response : AxiosResponse<any, any>) => {

    const { result, message, data } = response.data as ResponseDto<ValidateEmailResponseDto>;
    if(!result || !data){
      alert(message);
      return;
    }

    const validateMessage = data.result ? '이미 존재하는 이메일입니다.' : '사용가능한 이메일입니다.';
    // alert(validateMessage);
    setEmailValidateMessage(validateMessage);
  }

  //          Error Handler          //
  const emailValidateErrorHandler = (error : any) => console.log(error.message);

  return (
    <Box>
      {/*현재 상태 보여주는 용도 */email}  
      <FormControl sx={{ mt: '40px' }} error = {signUpError} fullWidth variant='standard'>
        <InputLabel>이메일 주소*</InputLabel>
        <Input type = "text" endAdornment ={
          <InputAdornment position = "end">
            <IconButton onClick={() => emailValidateHandler()}>
             <CheckBoxIcon/>
            </IconButton>
          </InputAdornment>
        }
        // value = {'d'} 하면 input에 d가 고정
        // value = {email} 하면 상태에 email의 값이 남아있다.
        // 보여지고 말고의 차이?
        value = {email} // onChange는 둘이 한 세트라 생각하면 편함 
        onChange={(event) => onEmailChangeHandler(event)} // 현재 입력된 텍스트를 읽어오기
        />
        <FormHelperText sx = {{ color : 'red'}}>{emailMessage} {emailValidateMessage} </FormHelperText>
        </FormControl>

      <FormControl  sx={{ mt: '40px' }} error = {signUpError} fullWidth variant="standard">
        <InputLabel htmlFor="standard-adornment-password">비밀번호*</InputLabel>
        <Input
          type={showPassword ? 'text' : 'password'}
          endAdornment={
            <InputAdornment position="end">
              <IconButton onClick={() => setShowPassword(!showPassword)}>
                {showPassword ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
          value = {password}
          onChange={(event) => onPasswordChangeHandler(event)}
        />
        <FormHelperText>
          {passwordMessage}
        </FormHelperText>
      </FormControl>
      <FormControl sx={{ mt: '40px' }} error={signUpError} fullWidth variant="standard">
        <InputLabel>비밀번호 확인*</InputLabel>
        <Input
          type={showPasswordCheck ? 'text' : 'password'}
          endAdornment={
            <InputAdornment position="end">
              <IconButton onClick={() => setShowPasswordCheck(!showPasswordCheck)}>
                {showPasswordCheck ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
          value = {passwordCheck}
          onChange={(event) => onPasswordCheckChangeHandler(event)}
        />
        <FormHelperText>{passwordCheckMessage}</FormHelperText>
      </FormControl>
    </Box>
  );
}

//          Component          //
interface SecondPageProps {
  signUpError : boolean;
}
function SecondPage({signUpError} : SecondPageProps) {
  //          Hook          //
  const{nickname, telNumber, address, addressDetail} = useSignUpStore();
  const{setNickname, setTelNumber, setAddress, setAddressDetail} = useSignUpStore();

  const [telNumberMessage, setTelNumberMessage] = useState<string>('');
  const telNumberValidator = /^[0-9]{0,13}%/;
  //const telNumberValidator = /^[0-9]{3}-[0-9]{3,4}-[0-9]{3,4}%/;

  //          Event Handler          //
  const onTelNumberHandler = (event : ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    const value = event.target.value;
    const isMatched = telNumberValidator.test(value);
    if(isMatched) setTelNumberMessage('');
    else setTelNumberMessage('숫자만 입력해주세요.');
    setTelNumber(value);
  }
  return (
    <Box>
      <TextField 
      sx = {{mt : '40px'}} 
      error = {signUpError}
      fullWidth label = "닉네임*" 
      variant = "standard" 
      value = {nickname} 
      onChange = {(event) => setNickname(event.target.value)}/>
      <TextField 
      sx = {{mt : '40px'}} 
      error = {signUpError}
      fullWidth label = "휴대폰 번호*" 
      variant= 'standard' 
      value = {telNumber} 
      onChange = {(event) => onTelNumberHandler(event)} helperText = {telNumberMessage}/>

      <FormControl sx = {{mt : '40px'}} error = {signUpError} fullWidth variant='standard' >
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
      error = {signUpError}
      fullWidth label = "상세 주소*" 
      variant='standard'
      value = {addressDetail} 
      onChange = {(event) => setAddressDetail(event.target.value)}/>
      <Box sx = {{display : 'flex', alignItems : 'center' , mt: '24px'}}>
      <Checkbox color = "default"/>
      <Typography sx = {{ mr : '4px', color : 'red'}}>개인정보동의</Typography>
      <Typography>더보기&gt;</Typography>
      </Box>
    </Box>
  )
}

interface Props {
  setLoginView: Dispatch<SetStateAction<boolean>>;
}
export default function SignUpCardView({ setLoginView }: Props) {

  //          Hook          //
  const { email, password, passwordCheck } = useSignUpStore();
  const { nickname, address, addressDetail, telNumber} = useSignUpStore();

  const [page, setPage] = useState<number>(1);
  const [signUpError, setSignUpError] = useState<boolean>(false);

  const emailValidator = /^[A-Za-z0-9]([-.]?[A-Za-z0-9])*@[A-Za-z0-9]([-.]?[A-Za-z0-9])*\.[A-Za-z0-9]{2,3}$/ //? 이렇게 적으면 A~Z, a~z 0~9까지만 문자로 지정해줄 수 있다.
  const passwordValidator = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!?_]).{8,20}%/

  //          Event Handler          //
  const onNextButtonHandler = () => {
    //todo : 이메일 / 비밀번호 / 비밀번호 확인 검증
    //? 해당 문자열 변수가 빈값인지 확인
    //? 1. 해당 변수 == '';
    //? 2. 해당 변수 길이 == 0;
    if (!email || !password || !passwordCheck) { // 스크립트에선 !으로 값이 비었는지 검사가능 / 자바에선 이러면 안됨
      setSignUpError(true);
      // alert('모든 값을 입력하세요.');
      return;
    }

    if(!emailValidator.test(email)) return;
    if(!passwordValidator.test(password)) return;
    if (password !== passwordCheck) return;
      // alert('비밀번호가 다릅니다.');

    //todo : 검증이 실패하면 return
    //todo : 검증이 성공하면 page 변경
    setSignUpError(false);
    setPage(2);
  };

  const onSignUpHandler = () => {
    if(!email || !password || !passwordCheck){
      // alert('모든 값을 입력하세요.');
      setSignUpError(true);
      setPage(1);
      return;
    }
    if(!nickname || !telNumber || !address || !addressDetail){
      setSignUpError(true);
      // alert('모든 값을 입력하세요.');
      setPage(2);
      return;
    }
    if(!emailValidator.test(email)) {
      setPage(1);
      return;
    }
    if(!passwordValidator.test(password)) {
      setPage(1);
      return;
    }
    if(password !== passwordCheck){
      // alert('비밀번호가 서로 다릅니다.');
      setPage(1);
      return;
    }

    setSignUpError(false);

    const data : SignUpDto = { email, password, nickname, address : `${address} ${addressDetail}` , telNumber } // passwordCheck,
    
    // console.log('axios 이전☆')

    // js는 비동기 처리 → 작업 중 대기 시간을 기다리지 않고 따로 작동시켜놓고 다음 작업으로 넘어감
    // 통신을 위한 axios, post : backend의 주소 담기, then : 작업 처리, catch : 에러 처리
    //? 1. 비동기 처리 (then 방법)
    axios.post(SIGN_UP_URL, data)
    .then((response) => signUpResponseHandler(response))
    .catch((error) => signUpErrorHandler(error))

    // await : 작업이 끝날 때 까지 기다리기 → 동기 처리
    // 호출되는 함수의 매개변수 앞에 async 붙여서 동기처리 해줘야됨
    // 도중에 에러 터지면 다음 작업 실행하지 않음
    // const response = await axios.post("http://localhost:4040/auth/sign-up", data);

    // console.log('axios 이후★')
  }

  //          Response Handler          //
  const signUpResponseHandler = (response : AxiosResponse<any, any>) => {

    const { result, message, data } = response.data as ResponseDto<SignUpresponseDto>; 

      if(result) setLoginView(true);
      else alert(message);
  }

  //          Error Handler          //
  const signUpErrorHandler = (error : any) => {
    console.log(error.response.status);
  }

  return (
    <Box display='flex' sx={{ height: '100%', flexDirection: 'column', justifyContent: 'space-between' }} >
      <Box>
        <Box display='flex' justifyContent='space-between' >
          <Typography variant='h4' fontWeight='900'>회원가입</Typography>
          <Typography variant='h4' fontWeight='900'>{page}/2</Typography>
        </Box>
        {page === 1 ? (<FirstPage signUpError = {signUpError}/>) : (<SecondPage signUpError = {signUpError} />)}
      </Box>

      <Box>
        {page === 1 && (<Button fullWidth variant='contained' size='large' sx={{ mb: '20px' }} onClick = {onNextButtonHandler}>다음 단계</Button>)}
        {page === 2 && (<Button fullWidth variant='contained' size='large' sx={{ mb: '20px' }} onClick = {onSignUpHandler}>회원가입</Button>)}
        <Typography textAlign='center'>이미 계정이 있으신가요?
          <Typography component='span' fontWeight='900' onClick={() => setLoginView(true)}>{" "}로그인</Typography>
        </Typography>
      </Box>
    </Box>
  )
}
