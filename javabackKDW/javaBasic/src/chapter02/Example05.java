package chapter02;

// 생성자 & 오버로딩
// 오버로딩 : 같은 이름의 메서드를 매개변수의 데이터 타입이나 갯수를 다르게 하여 여러개를 생성할 수 있도록 함

class Juice{
	String name;
	String company;
	int kcal;
	int volume;
	static int bbb;
	// 생성자
	// 인스턴스가 생성됨과 동시에 실행됨
	Juice(){
		name = "coke";
		company = "coca-cola";
		kcal = 200;
		volume = 500;
	}
	
	// 오버로딩에 의해서 생성자도 또 사용 가능
	Juice(String name, String company, int kcal, int volume){
		this(); // 또 다른 자신인 Juice() 생성자를 호출하는 거, 이런게 있다라고만 알고있자
		this.name = name; // this.name은 class에서 선언된 인스턴스 변수를 가리킨다.
		this.company = company;
		this.kcal = kcal;
		this.volume = volume;
	}
	
	void drink(int ml) {
		System.out.println("int drink!");
		volume -= ml;
	}
	
	void drink(float ml) {
		System.out.println("flaot drink!");
		volume -= ml;
	}
	
	void drink(int ml1, int ml2) {
		System.out.println("int int drink");
		volume -= ml1+ml2;
	}
}
public class Example05 {

	public static void main(String[] args) {
		
		Juice juice = new Juice(); // new 연산자가 Juice 생성자를 만들었다
		juice.name = "보성 홍차";
		juice.company = "동원";
		juice.kcal = 0;
		juice.volume = 500;
		
		Juice cola = new Juice("coke", "coca-cola", 200, 1000); // 생성자 매개변수로 인해 인스턴스 생성과 동시에 변수 초기화 
		System.out.println(cola.name); // name값을 초기화하지 않아도 Juice()가 기본으로 null을 초기화 해줬음
		System.out.println(cola.volume);
		
		juice.drink(100); // 정수 넣으면 정수가 매개변수인 drink 메서드가 나온다
		juice.drink(50.5F); // 실수 넣으면 마찬가지로 float drink 메서드 나옴
		juice.drink(10, 20);
		
		

	}

}
