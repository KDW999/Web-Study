package chapter04;

import java.util.Scanner;

public class Example01 {
	
	static void printArray(int index) throws Exception { // 예외 처리를 호출하는 곳에 짬때림
		int[] array = new int[] {1,2,3};
			System.out.println(array[index]);	
			System.out.println("인덱스 범위 벗어남");
	}

	public static void main(String[] args) {
		// 예외 처리
		// 컴파일이나 메모리 공간 부족 등 개발자가 코드상으로 조취를 취할 수 없는 에러가 아니라
		// 예측하고 처리할 수 있는 문제
		
//		double c = Double.valueOf("152");
//		System.out.println(c);
//		String d = String.valueOf(352);
//		System.out.println(d);
//		int f = (int)c;
//		c = (double)f;
		
		// 0으로 나누는 상황
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
		try {
			printArray(5);
		} catch (Exception e) {
			System.out.println("인덱스 범위 밖입니다.");
		}
		// 예외처리
		try { 
			// 예외가 발생할 수 있는 로직
			int result = 10 / 0;
		    System.out.println(result);
			
		} catch (Exception e) {
			// try 구문에서 예외가 발생했을 때 실행하는 로직
			System.out.println("0으로 나눌 수 없음");
		}  finally {
			System.out.println("종료합니다");
		}
		
		// 배열 인덱스 조회시 범위를 벗어날 때
//		int[] arr = new int[] {1, 2, 3};
////		arr[a] = 10;
//		try {
//			for(int i=0; i<arr.length; i++) {
//				if(arr[i] > arr[i+1])
//					System.out.println("앞의 수가 큼");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println("정상 종료");	
//		}
		
	}

}
