package chapter01;

import java.util.*;

public class Example01 {

	public static void main(String[] args) {
		// 데이터 타입
		
		// 정수형 타입
        // byte (1byte), short (2byte), int (4byte), long (8byte)
		byte b1 = 0;
		byte b2 = 127;
		byte b3 = -128;
		
		short s1 = 128;
		short s2 = 32767;
		short s3 = -32768;
		
		int i1 = 32768;
		int i2 = 2147483647;
		int i3 = -2147483648;
		
		long l1 = 2147483648L; // long 범위의 숫자는 long형태임을 나타내기 위해 L을 붙여준다.
		
		// 실수 타입
		// float (4byte), double (8byte)
		float f1 = 3.1415f;
		double d1 = 3.1415;
		
		// 논리 타입
		// boolean (1byte)
		boolean bl1 = true;
		boolean bl2 = false;

		// 문자 타입
		// char (2byte)
		char c1 = 'a';
		char c2 = 97;
//		System.out.println(c1);
//		System.out.println(c2);
		
		// 입력 (System.in)
		// java.util.Scanner Scanner 객체
		Scanner sc = new Scanner(System.in);
//		int inputNumber = sc.nextInt();
//		System.out.println(inputNumber);
//		
//		long inputCharacter = sc.nextLong();
//		System.out.println(inputCharacter);
		
		// 형변환
		// 묵시적 형변환 (자동)
		byte by1 = 100;
		int number1 = by1; // 시스템 내에서 byte인 by1를 int형으로 변환해줌
		System.out.println(number1);
	    float float1 = number1; 
	    System.out.println(float1);
	    
		// 명시적 형변환 (강제)
		// 사이즈(byte)가 큰 변수에서 작은 변수로 데이터를 저장할 때
	    int  number2 = 1000;
	    byte by2 = (byte)number2;
	    System.out.println((byte)number2);
	}

}
