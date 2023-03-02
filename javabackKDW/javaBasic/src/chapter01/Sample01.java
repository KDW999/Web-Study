package chapter01;

import java.util.*;

public class Sample01 {
	
    // 프로세스는 먼저 만들어놓고 개발
	// 로그인에 프로세스를 활용해서 변수 및 조건문 사용 활용법
	// 1. 사용자가 아이디와 비밀번호 입력
	// 2. 입력한 아이디와 비밀번호가 모두 입력됐는지 검증
	// 2-1 만약 하나라도 빈값이 있다면 '모두 입력하세요.' 출력 후 프로그램 종료
	// 3. 메모리에 저장된 아이디와 비밀번호를 확인
	// 3-1. 만약 하나라도 틀리다면 '로그인 정보가 일치하지 않습니다.' 출력 후 프로그램 종료
	// 3-2. 모두 맞다면 '로그인에 성공했습니다.' 출력 후 프로그램 종료
	public static void main(String[] args) {

		final String ID = "Java";
		final String PASSWORD = "123";

		// 1. 사용자가 아이디와 비밀번호 입력
		Scanner sc = new Scanner(System.in);
		String id, password; // 변수명은 풀네임으로 한 눈에 알아보게 해줄 수 있는게 좋다?
		System.out.print("아이디를 입력하세요. : ");
		id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요. : ");
		password = sc.nextLine();

        // System.out.println("id : " + id + " / pw : " + pw);
		// 2. 입력한 아이디와 비밀번호가 모두 입력됐는지 검증
		// 입력이 되지 않았을 때 문자열은 ""

		// 2-1 만약 하나라도 빈 값(== 입력되지 않음 =="")이 있다면 '모두 입력하세요.' 출력 후 프로그램 종료
		if (id.equals("") || password.equals("")) {
			System.out.println("모두 입력하세요.");
			// main method 종료
			return;
		}

		// 3. 메모리에 저장된 아이디와 비밀번호를 확인

		// 3-1. 모두 맞다면 '로그인에 성공했습니다.' 출력 후 프로그램 종료
		if (id.equals(ID) && password.equals(PASSWORD)) {  // id == ID / password == PASSWORD로 비교하면 변수값 비교가 아닌 주소값을 비교하게 된다.
			System.out.println("로그인에 성공했습니다.");
			return;
		}
		// 3-2. 만약 하나라도 틀리다면 '로그인 정보가 일치하지 않습니다.' 출력 후 프로그램 종료
		//if (!id.equals(ID) || !password.equals(PASSWORD)) {
		else {	
		System.out.println("로그인 정보가 일치하지 않습니다.");
			return;
		}
		// 틀린 경우만 if로 놓으면 로그인 성공한 경우는 조건문 없이 출력할 수도 있다.
		// 틀린 경우와 빈칸인 경우를 거르고 왔으면 남은 건 맞는 경우니까
	}

}
