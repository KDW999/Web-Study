//# 함수형 컴포넌트 자동완성
//? ES7 + React/Redux/React-native Snippets 설치
//? .tsx 파일 내에서 'rfc'로 함수형 컴포넌트를 자동 생성
import React, { useState } from 'react';
import NAEE, { NAME, PHONE } from 'src/constants';

//# 함수형 컴포넌트에서 매개변수를 받는 방법
//? 하나의 인터페이스를 선언하고 해당 인터페이스의 객체로 받음
interface Props{
    label : string;
    type : string;
}

//^ 함수형 컴포넌트에서는 일반적인 함수의 매개변수를 받는 방식과 다르게
//^ 매개변수를 하나의 묶음(객체)으로 받아야한다.
export default function InputGroup(props: Props) {
    //                  InputGroup({ label, type }: Props)    
    //# ts 비할당 구조화 
    //? 객체를 필드 단위로 파괴(분해)해서 사용 가능
    const{ label, type} = props;  

    //# 랜더링 : 화면에 표시할 웹 페이지를 만드는 과정
    //# Props와 state는 리액트에서 랜더링의 기준이 되므로 매우 중요
    //# State : 컴포넌트가 리렌더링 되는 기준
    //? 화면에서 사용되는 변수
    // let number = 0;
    //? state를 선언하는 방법
    //? const[상태명(변수명), 상태 변경 메서드(set 메서드)] = useState<타입>(초기값);
    const [number, setNumber] = useState<number>(0);
    const [inputValue, setInputValue] = useState<string>('');

    return (
        <div className="content">
            <div className="input-label">{label}</div>
            <div className="inline">
                {
                   //# 입력을 받았을 때에 대한 이벤트 처리
                   //? input의 값이 바뀌었을 때의 동작을 지정하고자 할 때는
                   //? html의 onChange 속성을 사용
                   //? onChange = { 함수 }   
                }
                <input className="input-style" type={type} onChange= { (event) => setInputValue(event.target.value)
                } />

            </div>
            {
            //# 클릭에 대한 이벤트 처리 
            //? 클릭했을 때의 동작을 지정하고자 할 때는 
            //? html의 onClick 속성 사용
            //? onClick = {함수}
            }
            <button onClick = {() => setNumber(number + 1)}>+</button>
        </div>
    );
}
