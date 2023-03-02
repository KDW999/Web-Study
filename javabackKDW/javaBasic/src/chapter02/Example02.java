package chapter02;

class Triangle{
	double base; // 밑변, 인스턴스 변수
	double height; // 높이
	double diagonal; // 대각선
	
	void createAndPrint() {
		base = 3;
		height = 4;
		diagonal = 5;
		
		System.out.println("=======");
		System.out.println("base : " + base + "height : " + height + "diagonal : " + diagonal);
		System.out.println("=======");  
	}
}

class Pythagoras {
	
	static String creator ="피타고라스"; // static이 붙은 변수는 한 공간에 저장되기에 다른 곳에서 변수값을 바꾸면 어디서 호출하든 변경된 값이 출력된다. 
	String creator2 ="아인슈타인";
	
	double base; // 밑변, 인스턴스 변수
//	double height; // 높이
//	double diagonal; // 대각선
	
	// SRP 단일 책임 원칙, 본 피타고라스는 클래스는 피타고라스와 관련된 기능만 있어야한다. 다른 공식은 있으면 안돼
	// 대각선 길이 구하는 메서드(함수), 대각선 제곱 = 밑변 제곱 + 높이 제곱
	static double getDiagonal(double base, double height) {
		 return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)); // 매개변수 없이 인스턴스 변수를 넣어서 스태틱 메서드를 사용하면 오류
		                                                            // 왜 static 메소드는 인스턴스 멤버(인스턴스 변수, 인스턴스 메소드)를 사용할 수 없는가?
//		                                                            -> 인스턴스 메소드를 이용하려면 인스턴스 변수를 사용하므로 객체 생성이 필요하다.
//                                                                    그러나 static 메소드는 항상 호출이 가능해야하는데, 객체가 있을지 없을지 모르기 때문이다.
//		                                                               가능성이 조금이라도 있으면 컴파일에서 막아버린다.
	}
	
	// 밑변 길이 구하는 메서드
	static double getBase(double diagonal, double height) {
		
		 return Math.sqrt(Math.pow(diagonal, 2) - Math.pow(height, 2));
	}
	
	// 높이 길이 구하는 메서드
	static double getHeight(double diagonal, double base) {
		 return Math.sqrt(Math.pow(diagonal, 2) - Math.pow(base, 2));
	}
}

public class Example02 {

	public static void main(String[] args) {
         // 객체 배열
		SmartPhone[] phones = new SmartPhone[3]; // Example01 클래스에서 SmartPhone 클래스를 선언해놨기에 사용 가능
		
		// 초기화 작업
		for(int i=0; i<phones.length; i++) {
			System.out.println(phones[i]);
			phones[i] = new SmartPhone();
		}
		
		System.out.println("========");
		System.out.println(phones); // 객체 배열을 그냥 출력하면 기존 배열이랑 마찬가지로 주소값이 나옴
		System.out.println("========");
		for(SmartPhone phone : phones) { // 클래스 객체 배열 phones 외에 phone이란 객체도 또 생성해줬음, for each문이라 순차적으로 반복할 수 있는 객체 phones가 우측에 온 것
			System.out.println(phone);
			phone.nation = "USA";
			phone.os = "IOS";
			phone.owner = "John";
			phone.telNumber = "010-1234-4321";
		}
		System.out.println("========");
		for(SmartPhone phone : phones) {
			System.out.println(phone.nation);
			System.out.println(phone.os);
			System.out.println(phone.owner);
			System.out.println(phone.telNumber);

		}
		System.out.println("========");

		// p
		int a = 10; // 밑변
		int b = 20; // 높이
		int c = 30; // 대각선
		
		// 대각선의 길이
//		Math.pow() : 정수의 거듭제곱
//		Math.sqrt()  제곱근
		
		// 대각선 길이
		double r1 = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // pow 함수로 a 2제곱 , b 2제곱을 합하고 sqrt로 제곱근(제곱했을 때 본체가 되는 숫자, 그냥 루트 붙인 거) 구하기
		
		// 밑변 길이
		double r2 = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
	
	   // 높이 길이
		double r3 = Math.sqrt(Math.pow(c, 2) + Math.pow(a, 2));
		System.out.println(r1 +" " + r2 +" " +r3);

//		Pythagoras py = new Pythagoras();
//		py.base = 10;
//		py.height = 20;
//		py.diagonal = 30;
//		
//		double digonal = py.getDiagonal();
		
		System.out.println(Pythagoras.creator);
		Pythagoras.creator = "newton";
		System.out.println(Pythagoras.creator);
		
		Pythagoras py2 = new Pythagoras();
		System.out.println(py2.creator);
		
		System.out.println(Pythagoras.creator); // static 선언된 변수는 클래스.변수 형태로 바로 출력 가능, 인스턴스를 따로 생성하지 않아도 사용 가능
		// 메서드도 마찬가지로 static 선언돼있으면 인스턴스 생성 없이 사용 가능 
//		System.out.println(Pythagoras.creator2); 
		
		System.out.println(Pythagoras.getDiagonal(a, b));
		
		// 삼각형 인스턴스
		Triangle triangle1 = new Triangle();
		
		// Triangle 인스턴스를 초기화 후 출력
		triangle1.base = 3;
		triangle1.height = 4;
		triangle1.diagonal = 5;
		
		System.out.println("base : " + triangle1.base);
		System.out.println("height : " + triangle1.height);
		System.out.println("diagonal : " + triangle1.diagonal);
		
		Triangle triangle6 = new Triangle();
		Triangle triangle7 = new Triangle();
		Triangle triangle8 = new Triangle();
		Triangle triangle9 = new Triangle();
		Triangle triangle10 = new Triangle();
		
		triangle6.createAndPrint();
		triangle7.createAndPrint();
		triangle8.createAndPrint();
		triangle9.createAndPrint();
		triangle10.createAndPrint();
		
	}

}
