import './App.css';
import AuthenticationView from './views/AuthenticationView';
import NavigationBar from './views/NavigationBar';
import { Routes, Route, useLocation} from 'react-router-dom';
import Main from './views/Main';
import Footer from './views/Footer';
import SearchView from './views/SearchView';
import MyPageView from './views/MyPageView';
import BoardWriteView from './views/Board/BoardWriteView';
import BoardUpdateView from './views/Board/BoardUpdateView';
import BoardDetailView from './views/Board/BoardDetailView';
import React, {useEffect} from 'react'
import { useCookies } from 'react-cookie';
import { useUserStore } from './stores';
import axios, { AxiosResponse } from 'axios';
import ResponseDto from './apis/response';
import { authorizationHeader, GET_USER_URL } from './constants/api';
import { GetUserResponseDto } from './apis/response/user';

//# Router 설계
//? 1. 'main' path 작성 : '/'
//? 2. 'auth' path 작성 : '/auth' (로그인 화면 / 회원가입 화면)
//? 3. 'myPage' path 작성 : '/myPage'
//? 4. 'boardSearch' path 작성 : '/board/search/:content'
//? 5. 'boardDetail' path 작성 : '/board/detail/:boardNumber'
//? 6. 'boardWrite' path 작성 : '/board/write'
//? 7. 'boardUpdate' path 작성 : '/board/update/:boardNumber'

function App() {

  const path = useLocation();
  const { setUser } = useUserStore();
  const [ cookies ] = useCookies(); 
  //? 설정을 해주지 않으면 브라우저를 껐다가 다시 접속하면 로그인은 풀려있으나 쿠키는 남아있다.
  //? → 브라우저를 끄면 쿠키도 날리거나
  //? → 쿠키가 남아있으면 로그인도 유지되게 해주기 → 밑에 적은 건 현재 이 방법 사용

  const getUser = (accessToken : string) => {
    axios.get(GET_USER_URL, authorizationHeader(accessToken)) //? header에 토큰 날려서 보냄
    .then((response) => getUserResponseHandler(response))
    .catch((error) => getUserErrorHandler(error));
  }

  const getUserResponseHandler = (response : AxiosResponse<any, any>) => {
    const { result, message, data } = response.data as ResponseDto<any>;

    if(!result || !data){
      return;
    }
    const user = data as GetUserResponseDto;
    setUser(user);
  }

  const getUserErrorHandler = (error : any) => {
    console.log(error.message);
  }

  useEffect( () => {
    const accessToken = cookies.accessToken;
    
    if(accessToken) getUser(accessToken);
    
  },[])

  return (
    <>
    <NavigationBar/>
    <Routes>
      <Route path = '/' element = {(<Main/>)}/> {/* 메인화면 */}
      <Route path = '/auth' element = {(<AuthenticationView/>)}/> {/* 로그인, 회원가입 */}
      <Route path = '/myPage' element = {(<MyPageView/>)}/> {/* 마이 페이지 */}
      <Route path = '/board'>
        <Route path = 'write' element = {(<BoardWriteView/>)}/> {/* 글쓰기 */}
        <Route path = 'search/:content' element = {(<SearchView/>)}/> {/* 검색 화면 */}
        <Route path = 'detail/:boardNumber' element = {(<BoardDetailView/>)}/> {/* 글 세부내용 */}
        <Route path = 'update/:boardNumber' element = {(<BoardUpdateView/>)}/> {/* 글 수정 */}  
      </Route>
    </Routes>
    {path.pathname !== '/auth' && (<Footer/>)}
    </>
  );
}

export default App;
