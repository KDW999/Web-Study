// 스토어 관리
// 다른 파일의 스테이트(상태)를 여기에 가져와서 저장하고 필요할 때 마다 호출

import useSignUpStore from './sign-up.store';
import useUserStore from './user.store';

export { useSignUpStore, useUserStore }; // 파일 단위라는 걸 인식시키기 위해 중괄호 안에 넣어줌