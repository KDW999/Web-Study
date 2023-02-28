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
