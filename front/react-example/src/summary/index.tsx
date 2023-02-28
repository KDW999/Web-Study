
  //# typescript의 데이터 타입
  //? 숫자 타입 : number
  //? 문자열 타입 : string
  //? 논리 타입 : boolean

  //# typescirpt의 변수 선언 방식
  //? var : 변수, let : 변수, const : 상수

  //# java에서의 변수 선언
  //? 접근제어자 기타제어자 데이터 타입 변수명

  //# typescript에서의 변수 선언
  //? var 변수명; / let 변수명: 데이터타입;
  var tmp : number = 10;
  let tmp2;

  //# typescript에서 상수 선언
  //? const 상수명 = 값;
  const tmp3 = 'costant';

  //# typescript에서의 비교 연산자
  let a :any = 10;
  let b :any = 10;
  
  //# ==, != : 값만 비교
  alert(a == b); // 타입이 다른데 true 나오게 된다.
  
  //! ===, !== : 값과 타입까지 비교
  alert(a === b);

  // typescript에서의 나눗셈 연산
  let tmp5 = 10 / 3; // 333333...
  // alert(tmp5);

  // @ java에서 객체 생성
  // 접근제어자 기타제어자 클래스 참조변수명 = new 생성자(인자, ...)

  // # typescript에서 객체 생성
  // const 참조변수명[: 클래스명] = new 생성자(인자, ...); / 타입 스크립트는 오버로드 기능이 없음
  // const 참조변수명[: 클래스명] = { key : value, ...};
  // const 참조변수명[: 인터페이스명] = {key : value, ...}; // 인터페이스는 메서드만 만들지 않고 여러 타입의 데이터를 선언만

  //! typescript에서 인터페이스를 선언하는 방법
  //? interface 인터페이스명 { 필드명 : 타입, ...}
  interface Human {
    name : string,
    num : number
}
const me : Human = {name: 'kdw', num : 123};
me.name;
const me2 : Human = me;
const me3 = {nmae : 'dw',
             num : 31,
            gender : '남'};

  //? typescript에서는 {}를 배열이 아닌 객체의 묶음으로 표현
  //? 이렇게 {} 묶어서 객체를 표현하는 방식을 JSON 포맷이라 한다.
  //? 배열의 묶음은 []로 표현

  export default tmp;