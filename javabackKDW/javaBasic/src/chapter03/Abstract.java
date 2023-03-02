package chapter03;

// 추상 클래스 : 
// 클래스를 추상적으로만 표현해둔 클래스
// abstract 제어자를 포함
abstract class Animal2{
	String eyes;
	String ears;
	String legs;
	
	// 추상 메서드
	// 해당 메서드에 대해 선언만 해둠
	abstract void eat();
}

class Dog extends Animal2{ // 추상 클래스를 상속하면 추상 클래스에 있던 메서드를 재정의 해줘야 됨
	String tails;
	void eat() {
		System.out.println("사료 먹음");
	}
}


public class Abstract {
	public static void main(String[] args) {
//		Animal2 animal = new Animal2(); 추상 클래스는 인스턴스 생성이 안됨 / 정해진 값이 없기에
        Dog dog = new Dog();
        dog.eat();
	
	}
}
