import React from 'react'

export default function JsxTsx() {

const text = "JSX + TSX";
const trueFlag = true;
const falseFlag = false;
const numberArray = [1, 2, 3, 4, 5];
//# JSX, TSX
//? JSX : Javascript 기반
//? TSX : Typescript 기반

//? TSX
//? - TypeScript XML
//^ XML : eXtensible Markup Language
//? - React에서 Typescript로 HTML을 작성할 수 있도록 해주는 파일
//? ts파일이면 html 기능 쓸 수 없다

//# 1. tsx 파일에서 작성된 typescript 컴포넌트 함수는
//# return의 ()안에 HTML 태그를 포함할 수 있음
//? typescript return에 HTML을 표기하려면 () 묶어줘야함
//^ return() 안에는 최상위 부모 태그가 무조건 1개 있어야 한다. 
//! 0개도 안됨

//? return() 안에서 TS를 사용하려면 {}로 묶어서 작성
//^ {}를 써서 TS를 작성하고 싶으면 필수적으로 HTML 태그 안에 있어야함

//? return () 안의 {} 안에서 다시 HTML을 표기하려면 ()로 반환 해줘야함

//# 2. return () 안에서는 제어문을 사용할 수 없음
//? if문 / for문 사용 불가
//? 변수와 연산자만 사용 가능

//? if문 대체 : 논리 연산자 / 삼항 연산자
//? for문 대체 : 배열 객체의 map 메서드 사용

//# 3. return() 안에서는 html 주석 안됨
//? {}를 사용하여 TS 주석을 사용해야 됨

//# 4. TSX는 XML 기반으로 HTML을 표기하기 때문에 문법이 정확해야한다.
//? 모든 태그를 다 닫아줘야하고 모든 HTML 요소를 소문자로 작성
//? HTML 속성이 대소문자를 구분

  return (
    <div>
        {trueFlag && (<div>true</div>)}
        {falseFlag && (<div>false</div>)}
        {trueFlag || (<div>or True</div>)}
        {falseFlag || (<div>false</div>)}
        {trueFlag ? (<div>true</div>) : (<div>false</div>)}
        {numberArray.map((number) => {return (<div>{number}</div>)})}
    </div>
  )
}