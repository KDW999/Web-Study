import React from 'react'

export default function Es6TypeScript() {
    //# 1. 변수 선언
    //? 변수를 선언하는 방법
    //? ES6 -> let 변수명; ES6는 JS의 버전을 의미
    //? TS -> let 변수명 : 데이터 타입;
    let integer;
    let integer2 : number;

    //# 2. 상수 선언
    //? 상수를 선언하는 방법
    //? ES6 -> const 상수명 = 초기값;
    //? const 상수명 : 데이터 타입 = 초기값
    const INTEGER = 5;
    const INTEGER2 : number = 10;

    //^ TS의 경우 변수 혹은 상수를 선언과 동시에 초기화하면
    //^ 해당 변수 혹은 상수의 데이터 타입을 자동으로 추론함
    //? typeof(변수) -> 해당 변수의 타입을 문자열로 나타내줌
    console.log(typeof(INTEGER));
    console.log('야호');

    //# 3. 데이터 타입
    //? TS -> string, number, boolean, null, undefined, any, object
    

    //? string : 문자열
    //? 문자열을 표현할 때는 '', "", ``(backtick)
    let str : string = '10'

    const description = "str의 값은 " + str + "입니다.";
    const description2 = `str의 값은 ${str}입니다.`; // 백틱 사용법
    alert(description2);
    
    //? number : 숫자
    //? 실수와 정수 모두
    let num : number = 15;
    // num = 3.14;

    //? boolean : 논리
    let bool : boolean = true;

    //? null : 아무 것도 지정되지 않은 상태
    // str = null;
    let n : null = null;

    //? undefined : 정의되지 않은 상태 
    const obj : any = {};
    console.log(obj.a);

    //? any : 모든 타입을 받는 타입
    let variable : any = 3;
    variable = "15";
    variable = true;

    //? object : 객체 타입 (Java의 Object class와 동일)
    let obj2 : object = {}; // 묶음의 객체를 받음
    obj2 = { a : 10};
    obj2 = [ 10, 20 ]
    // obj2 = 3; 이거 안됨

    //# TS의 신기한 기능
    //? |, &
    //? | : 한 변수에 두 개 이상의 데이터 타입을 지정해줄 때 사용
    let vary : string | number | null;
    vary = 'str';
    vary = 5;
    vary = null;
    
    //! 역으로 생각했을 때 데이터 타입이 지정된 변수는 필수적으로 값이 포함되어 있어야 한다는 뜻
    // let variable3 : string = null;

    //? & : 한 변수에 두 개의 데이터 타입을 *동시에* 지정
    interface I1{
        a : string;
    }
    interface I2{
        b : number;
    }

    let implement : I1 & I2 = { // 자바의 상속과 같진 않지만 유사한
        a : 'str',
        b : 2
          }

    //# 4. 연산자
    //? 비교 연산 중 ==, ===(, !=, !===)
    //? == : 데이터 타입은 비교 X
    const str1 : any = '10';
    const num1 : any = 10
    const flag1 : boolean = str1 == num1; // '10'과 10은 다른 타입이지만 true가 나오게 됨
    console.log(flag1);

    //? === : 데이터 타입까지 비교함
    const flag2 = str1 === num1;
    console.log(flag2);

    //# 5. if문의 조건
    //? ES6와 TS에서는 false, '', 0, null, undefined는 모두 false / 나머지는 모두 true
    const emptyArray : null = null;
    if(!emptyArray) console.log('a');

    //# 6. for
    //? foreach 반복문
    //? Java -> for(요소 데이터타입 변수명 : 반복해서 접근할 배열) {}
    //? Ts -> for(const 변수명 of 반복해서 접근할 배열){}
    const numberArray = [1, 2, 3];
    for(const item of numberArray){
      console.log(item);
    }

    //# 7. interface
    //? TS -> interface를 데이터 타입 형태로 사용
    interface IExample {
      a : string;
      b : number;
      c : boolean;
    }
    const object1: IExample = { 
     a : 'a',
     b : 1, 
     c : true
    };

    //! 객체형의 데이터 타입을 지정할 때는 3가지 방법을 쓸 수 있다.
    //^ 1. interface
    //^ 2. class 
    class Example{ // class 쓸 땐 생성자도 같이
      a : string;
      b : number;
      c : boolean;

      constructor(a : string, b:number, c : boolean){ // ts의 생성자 쓰는 방식
        this.a = a;
        this.b = b;
        this.c = c;
      }
    }

    const object2 : IExample = new Example('a', 1, true); // class에서 생성자를 만들면 new 생성자도 가능
    const object3 :  Example = { a : 'a' , b: 1, c : true};

    //^ 3. type
    type TExample = {
      d : string,
      e : number,
      f : boolean
    }
    
    const object4 : TExample = {
      d : 'a',
      e : 1,
      f : true
    };
     
    //# 8 : 삼항 연산자, Spread 연산자, 비구조화 할당
    //? 삼항 연산자
    //? (조건) ? 참일 때 결과값 : 거짓일 때 결과값
    const RESULT = num > 10 ? '양수' : '양수가 아님';
    console.log(RESULT)

    //? 비구조화 할당
    //? object 타입(객체와 배열)의 요소를 하나씩 직접 거내서 사용할 수 있도록 하는 것
    //? State도 배열 형태의 비구조화 할당
    // const {a, b, c} = object1;
    // console.log(a, b, c);
    // const [a1, b1, c1] = numberArray;
    // console.log(a1, b1, c1);

    //? Spread 연산자 
    //? ...객체 : 객체에서 지정한 요소를 제외하고 남은 요소를 객체로 묶음 처리
    //? 1. 비구조화 할당에 쓰일 때는 직접 뽑은 요소를 제외한 나머지 요소를 하나로 묶어줌
    const {a, ...spread1 } = object1;
    console.log(a);
    console.log(spread1);

    //? 2. 새로운 객체를 생성할 때 가지고 있는 객체를 분해해서 요소로 추가
    const example1 = { a1 : 'a', object1}; // object1는 하나의 묶음 상태로 있다.
    console.log(example1);
    const example2 = { a1 : 'a', ...object1}; // object1은 묶음 안에 있는 요소들을 다 분해해서 가진다.
    console.log(example2);

    let state = {email : 'email', password : 'password', passwordCheck : 'passwordCheck'};
    state = {...state, email : '이메일'};
    // state = { password : 'password', passwordCheck : 'passwordCheck', email : '이메일', };
    console.log(state)

    // const object5 : TExample = new Example('a', 1, true);

    //# 9. Enum
    //? Enumerated Type : 열거형 타입
    enum ENUMERATED {
      APPLE = 'apple',
      BANANA = 'banana',
      CARROT = 'carrot'
    }

    const fruit = ENUMERATED.APPLE;
    console.log(fruit);

    let fruit2 : ENUMERATED = ENUMERATED.BANANA;
  return (
    <div>index</div>
  )
}
