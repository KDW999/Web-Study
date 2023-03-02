package chapter05;

abstract class SuperClass{
    abstract void superMethod();
}

class SubClass extends SuperClass{
	
	@Override // 실수 방지용, 이건 이런 용도다
	void superMethod() {
		System.out.println("자손 메서드");
	}
}

public class Example02 {
	
	// 열거형
	enum EXAMPLE_ENUM {
		FIRST(1), SECOND(2), THIRD(3);
		
		EXAMPLE_ENUM(int i){
			
		}
	
	};
	static final int FIRST = 1;
	static final int SECOND = 2;
	static final int THIRD = 3;

	public static void main(String[] args) {
		SubClass sc = new SubClass();
		sc.superMethod();
		System.out.println(EXAMPLE_ENUM.THIRD.ordinal());

	}

}
