import React, { useState } from 'react'
import KakaoSignIn from './Views/KakaoSignIn';
import NaverSignIn from './Views/NaverSignIn';
import 'src/App.css';
import { Link, Route, Routes } from "react-router-dom"
import MenuAppBar from 'src/components/MenuAppBar';
import Es6TypeScript from './Views/Es6TypeScirpt';
import JsxTsx from './Views/JsxTsx';
import { VIEW } from './enums';
import Hook from './Views/Hook';
import Mui from './Views/Mui';
import RouterView from './Views/RouterView';
import { Typography } from '@mui/material';

export default function App() {

  const [view, setView] = useState<VIEW>(VIEW.KAKAO);

  return (
    <div>
      <MenuAppBar/> {/* index의 setView와 App의 setView는 다르기에 가져와서 다시 값을 사용해줘야한다 */}
      
      <div>

        {/* 소괄호안에서는 조건문을 쓸 수 없어서 논리연산자를 활용*/}
        {/* view === 'naverSignIn' && (<NaverSignIn/>) */} 
        {/*
        //# 삼항 비교 연산자
        //? 조건에 따라서 참일 때의 결과값과 거짓일 때의 결과값을 지정해서 
        //? 해당하는 경우의 값을 반환
        //? 조건 ? 참일 때 결과값 : 거짓일 때 결과값
        */}

        {/* <></> : 의미없는 빈 태그 */}
   
        <Routes>
          <Route path = {VIEW.NAVER} element = {(<NaverSignIn/>)}/>
          <Route path = {VIEW.KAKAO} element = {(<KakaoSignIn/>)}/>
          <Route path = {VIEW.TYPESCRIPT} element = {(<Es6TypeScript/>)}/>
          <Route path = {VIEW.TSX} element = {(<JsxTsx/>)}/>
          <Route path = {VIEW.HOOK} element = {(<Hook/>)}/>
          <Route path = {VIEW.MUI} element = {(<Mui/>)}/>
          <Route path = {'router'} element = {(<RouterView/>)}/>
          <Route path = {'router/:pathValue'} element = {(<RouterView/>)}/>
          <Route path = '*' element = {(<Typography variant='h2'>Not Found 404</Typography>)}/>
        </Routes>

        {/*
        view === VIEW.NAVER ? (<NaverSignIn/>) : 
        view === VIEW.KAKAO ? (<KakaoSignIn/>) : 
        view === VIEW.TYPESCRIPT ? (<Es6TypeScript/>) : 
        view === VIEW.TSX ? (<JsxTsx/>) :
        view === VIEW.HOOK ? (<Hook/>) : 
        view === VIEW.MUI ? (<Mui/>) : 
        view === VIEW.ROUTER ? (<RouterView/>) :(<></>)
      */}
  
      </div>
    </div>
  );
}
