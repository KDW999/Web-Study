// 한 줄 주석
/* 공간 주석 */

//? 파일명이 index.확장자일 경우 index 부분은 쓰지 않아도
//? 해당 파일이 속해 있는 폴더명으로 import가 가능
import InputGroup from 'src/components/InputGroup/index';
import BirthInputGroup from 'src/components/BirthInputGroup';
import ButtonGroup from 'src/components/ButtonGroup';
import './style.css';

//# java method 생성
//? 접근 제어자 기타 제어자 반환타입 메서드명(파라미터){};

//# typescript method 생성
//? (1) function 메서드명(파라미터 [: 파라미터 타입]) [:반환타입]{};
//? (2) 자바스크립트, 타입스크립트는 메서드를 변수로 인식
//     const 메서드명 = (파라미터[ : 파라미터 타입])[: 반환타입] => {..}

//^ (1)
//! react Component는 Type Script가 기반
function NaverSignIn() {

    // ! return에는 하나의 태그만 올 수 있다.
    //? 확장자가 .jsx / .tsx일 때
    //? 함수형 컴포넌트의 return에서 ()안에
    //? html 태그를 사용할 수 있음
    //? return의 ()안에서 ts 문법을 사용하고 싶다면
    //? {} 안에 작성
    /* 네이버 회원가입 화면*/
    /* 레이아웃 구성 */

    /* 컨테이너 레이아웃 */
    return (

        <div>
    
              {/* 가운데 레이아웃 */}
            <div>
                {/* 로고 레이아웃 */}
                <div id="logo-container">
                    <a id="logo">
                        NAVER
                    </a>
                </div>

                {/* 컨테이너 레이아웃 */}
                <div id="container">
                    {/* //^ 함수형 컴포넌트에 매개변수를 전달할 땐 */}
                    {/* //^ html 태그에서 속성 값을 지정하는 방식과 동일하게 사용 */}
                    {/* 아이디 레이아웃 */}
                    <InputGroup label='아이디' type='text' />

                    {/* 비밀번호 레이아웃 */}
                    <InputGroup label='비밀번호' type='password' />
                    {/* 비밀번호 확인 레이아웃 */}
                    <InputGroup label='비밀번호 확인' type='password' />

                    {/* 이름 레이아웃*/}
                    <InputGroup label='이름' type='text' />

                    {/* 생년월일 레이아웃*/}
                    <BirthInputGroup />

                    {/* 버튼 레이아웃 */}
                    <ButtonGroup />
                </div>
                <br />
            </div>
        </div>
    );
} 

//^ (2)
const Description = () => {
    //^ {}(중괄호) 안에서는 타입스크립트를 인식한다.

    //^ () 소괄호는 html 태그를 인식한다.
    //^ return () 안에서 typescript를 사용하려면 {}로 해당 구문 감싸기

    //^ {} 안에서 html 태그를 사용하려면 return ()적고 안에 html 코드 작성
    return (
        <div></div>
    );
}


export default NaverSignIn;
