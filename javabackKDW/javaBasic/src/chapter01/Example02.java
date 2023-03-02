package chapter01;

public class Example02 {

	public static void main(String[] args) {
		// 배열
		// 변수가 나열된 형태
		int[] numbers;
		numbers = new int[10]; // new가 붙으면 참조변수가 되는거다 new가 붙은 애를 직접 찍어서 출력하려하면 안된다
//		System.out.println(numbers); // numbers는 변수가 아니라서 출력하면 메모리의 주소값이 나온다.
		
		char[] characters;
		characters = new char[10];
//		System.out.println(characters); // 문자열은 빈 공간으로 찍힌다.
		
		// 배열 초기화
		int[] arrNumber = new int[] {1, 2, 3};
		System.out.println(arrNumber.toString());
		System.out.println(arrNumber[0]);
		System.out.println(arrNumber[1]);
		System.out.println(arrNumber[2]);
		System.out.println(arrNumber.length);
		
		char[] string = {'h', 'e', 'l', 'l', 'o'};
		System.out.println(string);
		System.out.println(string.length);
		string[0] = 'k';
		System.out.println(string);
		
		// 다차원 배열
		// 배열의 요소가 배열인 형태
		int[][] arr2 = new int[2][3];
		int[][] arrNum2 = {{0,1,3}, {2,3,4}};
		System.out.println(arrNum2[0][1]);
		
		// 문자열
		// 단어 혹은 문장을 쉽게 표기하기 위한 Java object class
		String str1;
		str1 = new String();
		str1 = "apple";
		System.out.println(str1);
		String str2 = "banana";
		System.out.println(str2);
	}
	

}
