package chapter04;

import java.util.Random;

public class Example03 {

	public static void main(String[] args) {
		// Wrapper 클래스
		// 기본 데이터 타입을 클래스를 이용해서 객체로 다룸
		// int -> Integer
//		Integer integer = 100;
		
		// 기본 타입일 경우 객체형의 문자열로 변경 불가
//		int number =100;
//		String numberStr = number;
//		System.out.println(numberStr);
		
		// Wrapper 클래스로 작성된 형태는 문자열로 변경 가능
//		String numberStr = integer.toString();
//		numberStr = Integer.toString(3);
//		System.out.println(numberStr);

		// 기본 타입일 경우 null로 초기화 불가
//		int number = null;
		
		// Wrapper class로 작성된 형태는 null로 초기화가 가능
//		Integer number = null;
//		int i = integer.intValue();
//		double d = integer.doubleValue();
		
		// Random Class
		// 무작위의 int, long, boolean, float, double 값을 가져오는 Java API Class
		
		Random rd = new Random();
		int a = rd.nextInt(3);
		for(int i=0; i<a; i++) {
		System.out.println(a);
		a = rd.nextInt(46);
		System.out.println(a);
		}
	}

}
