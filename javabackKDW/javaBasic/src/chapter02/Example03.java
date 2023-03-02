package chapter02;

class MyMath {
	
	// 정삼각형 넓이 구하는 메서드
	static double getEquiateral_TriangleArea(double side) {
		// 매개변수 검증
		if(side <= 0) return 0;
		
		double result = (Math.sqrt(3) / 4) * Math.pow(side, 2) ;
		return result;
	}
	
	
	// 정삼각형 높이 구하는 메서드
	static double getEquiateral_TriangleHeight(double side) {
		
		// 매개변수 검증
		if(side <= 0) return 0;
		
		double equiateral_TriangleHeight = (Math.sqrt(3)/2) * side;
		return equiateral_TriangleHeight; 
	}
	
	// 1증가
	static int increase(int number) {
		number++;
		System.out.println("In of Method");
		System.out.println(number);
		return number;
	}
	
	static void increaseTriangle(Triangle triangle) { // 클래스 인스턴스를 매개변수로 사용, 주소값 받음
		triangle.base++; // 메모리 주소를 찾아가서 값에 ++했기에 메인 메서드로 돌아가서 변수를 호출하면 변경된 값이 나오게 된다.
		triangle.height++;
		triangle.diagonal++;
	}
}

public class Example03 {

	public static void main(String[] args) {
		double side = 10.0;
		double equiateral_TriangleArea = MyMath.getEquiateral_TriangleArea(side);
		System.out.println(equiateral_TriangleArea);
		
		double equiateral_TriangleHeight = MyMath.getEquiateral_TriangleHeight(-10);
		System.out.println(equiateral_TriangleHeight);
		
		int number = 10;
		int afterNumber = MyMath.increase(number); // 리턴값을 변수에 저장하면 메서드내에서 변경됐던 값을 출력할 수 있으나, 메서드에서 연산했다고
		                                          // 메인 메서드에 있는 원본에 영향이 가진 않는다.
		System.out.println("Out of Method");
		System.out.println("나 원본값 : "+number);
		System.out.println("나 메서드 리턴값 : "+afterNumber);
		number = MyMath.increase(number);
		
		Triangle triangle = new Triangle(); // 참조 변수 triangle은 메모리 주소를 가지고 있다.
		triangle.createAndPrint();
		System.out.println(triangle);
		
		MyMath.increaseTriangle(triangle); // 주소값 triangle을 인자로 주고 호출
		System.out.println(triangle.base); // 원래 원본 값을 바꿀 수 없으나 인스턴스는 메모리 주소에 직접 찾아가기에 메서드 내에서 값이 변화되면 영향을 미친다.
		System.out.println(triangle);
	}

}
