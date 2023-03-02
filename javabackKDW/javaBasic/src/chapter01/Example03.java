package chapter01;

public class Example03 {

	public static void main(String[] args) {
		// 산술 연산자
		// 더하기 (+)
//		System.out.println(8+3);
//
//		// 빼기 (-)
//		System.out.println(8-3);
//		
//		// 곱하기 (*)
//		System.out.println(8*3);
//		
//		// 나누기 (/)
//		System.out.println(8/3.0);
//		
//		// 나머지 (%)
//		System.out.println(8%3);
		
		// 증가 (++), 증감 연산자는 변수에만 사용 가능
//		int plus1 = 0;
//		System.out.println(plus1++); // 출력 후에 1증가
//		System.out.println(plus1);
//		
//		int plus2 = 0;
//		System.out.println(++plus2); // 출력 전에 1증가
//		System.out.println(plus2);
//		
//		// 감소 (--) 
//		int minus1 = 0;
//		System.out.println(minus1--);
//		System.out.println(minus1);
//		
//		int minus2 = 0;
//		System.out.println(--minus2);
//		System.out.println(minus2);
//		
//		// 대입 연산자
//		// = 
//		int number = 8;
//		//number = number + 3;
//		number += 3;
//		System.out.println(number);
//		
//		number -= 3;
//		System.out.println(number);
//		
//		number *= 3;
//		System.out.println(number);
//		
//		number /= 3;
//		System.out.println(number);
//		
//		number %= 3;
//		System.out.println(number);
		
		// 비교 연산자
		// 같다 ==
//		System.out.println(8==3);
//		
//		// 다르다 !=
//		System.out.println(8 !=3);
//		
//		// 크다 >
//		System.out.println(8>3);
//		
//		// 작다 <
//		System.out.println(8<3);
//		
//		// 크거나 같다 >=
//		System.out.println(8>=3);
//		
//		// 작거나 같다 <=
//		System.out.println(8<=3);
		
		// 논리 연산자
		// and 연산자 && -> *
        // boolean -> 0 : false, 0! = true (1)
//		System.out.println(1*1); // return 1
//		System.out.println(false && true); // return false
		// dead code = 있든 없든 연산에 영향을 미치지 않아서 실행되지 않는 죽은 코드
		
		// or 연산자 || -> +
		// boolean -> 0 == false, 0! = true
//		System.out.println(0 + 0); // return 0
//		System.out.println(true || false); // return true
		
		// and, or 연산의 규칙
		// 양 옆은 논리만
		// and : 연산 과정 중 false가 존재하면 무조건 false
		// or : 연산 과정 중 true가 존재하면 무조건 true
		// 해당 논리 뒤에 연산은 실행하지 않음
		
		int a = 0;
		int b = 0;
		System.out.println(false && (++a > 0)); // (++a >) 0은 논리가 아니지만 ++a > 0가 true를 출력하기 때문에 가능
		System.out.println(a); // 원랜 a++가 작동되서 a가 1증가하여야 하나 a++ > 0가 데드코드라서 실행되지 않기에 a가 0그대로다
		
		// not 연산자
//		System.out.println(!true);
//		System.out.println(++a > 0);
	}

}
