package chapter03;

// 인터페이스
// 추상도가 가장 큰 설계도
// 일반 메서드, 멤버 변수는 사용 불가능
// static final로 선언된 상수 / abstract로 선언된 추상 메서드만 가질 수 있음 (자바 8버전의 경우 이렇게 해야했음)
public interface IExample01 {
	
	// 인스턴스에는 static final로 선어된 상수만 선언 가능
	public static final int NUMBER = 0;

	// 인터페이스에는 추상메서드만 선언 가능
	void hello();
}

interface IExample03 {
	public static final String STRING = "string";
}

// 인터페이스 상속
// 인터페이스 간의 상속은 extends
// 인터페이스는 다중 상속 가능
interface IExample02 extends IExample01, IExample03{
	
	public static final double DECIMAL = 10.5;

}

// 인터페이스 구현
// 인터페이스를 클래스에 구현할 때는 implements 키워드 사용
class Example implements IExample02{
	
	IExample02 ex = new Example();
	
	// 인터페이스에 작성된 추상 메서드는 반드시 = 추상 클래스도 마찬가지
	// 모두 구현 해야함
	public void hello() {
          System.out.println("하이");		
	}
}

class Example2 implements IExample02{
	@Override
	public void hello() {
		System.out.println("하이2");
	}
}

class Exmaple3{
	public static void main(String[] args) {
		IExample02 exam1 = new Example();
		IExample02 exam2 = new Example2();
	System.out.println(exam1.NUMBER);	
	exam1.hello();
		System.out.println(1);
	}
}



