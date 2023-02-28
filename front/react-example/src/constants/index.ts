import { VIEW } from "src/enums";

const AGE = 20;
const BIRTH = '010101';
//# export : 해당 파일 외부에서 특정 변수 혹은 함수등을 사용할 수 있도록 내보내는 역할
//^ export 요소; -> 파일의 요소로 import를 할 수 있도록 함
//^                 한 파일 내에서 여러 개를 export로 내보낼 수 있음
//^                 import하는 파일에서 받아올 때
//^                 import { 요소, 요소, ...} from '파일 경로';
//^                 로 받을 수 있음
//! export 요소; 로 내보낸 요소는 import할 때 내보낸 요소의 이름과 동일한 이름으로 받아야 한다.

export const NAME = "KDW";
export const PHONE = "123";
export let a = 3;

//^ export default 요소; -> 파일의 기본 값으로 import를 할 수 있도록 함
//^                         한 파일 내에서 하나만 export default로 내보낼 수 있음
//^                         import하는 파일에서 받아올 때
//^                         import 이름 from '파일 경로';
//! export default 요소; 로 내보낸 요소는 import할 때 내보낸 요소의 이름과 달라도 된다.
export default AGE;

export const PAGES = [
    {
        title : 'Naver',
        viewValue : VIEW.NAVER
    },
    {
        title : 'Kakao',
        viewValue : VIEW.KAKAO
    },
    {
        title : 'ES6 + TypeScript',
        viewValue : VIEW.TYPESCRIPT
    },
    {
        title : 'JSX + TSX',
        viewValue : VIEW.TSX
    },
    {
        title : 'Hook',
        viewValue : VIEW.HOOK
    },
    {
        title : 'Mui',
        viewValue : VIEW.MUI
    },
    {
        title : 'Router',
        viewValue : VIEW.ROUTER
    }
]