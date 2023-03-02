package chapter02;

import chapter02.entity.*;
import chapter02.entity.BusDriver;
import chapter02.entity.Police;

class People{
	String name;
	int age;
	String gender;
	String address;
	String email;
	
	People(String name, String gender){ // 상위 클래스에 생성자가 있다면 하위 클래스에도 생성자를 만들어주어야 한다
		this.name = name;
		this.gender = gender;
	}
	
	People(){ // 상위 클래스에 생성자가 있다면 하위 클래스에도 생성자를 만들어주어야 한다
		
	}
	
	void eatBreakfast() {
		System.out.println("7시에 아침을 먹습니다.");
	}
}

//// 상속을 사용하는 이유
class Developer extends People{	
	String language_Skill;
	String company;
	String developer_Position;

	Developer(String name, String gender, String comapny){
		// super() : 슈퍼 클래스의 생성자
		// super는 상위 클래스에 있는 선언된 변수, 메서드를 그대로 사용하게 해준다
//		super(name, gender); // 하위 클래스에서 상위 클래스 생성자를 호출할 땐 super를 붙이고 매개변수를 적어준다.
		
		this.company = company;
		
	}
	
	void eatBreakfast(int time) { // 부모 클래스에 있던 메서드를 자식 클래스에서 재정의 -> 오버라이딩 / 반환타입, 이름, 매개변수 같아야 됨
		System.out.println(super.name + "은 "+ time+"시에 아침 밥 먹습니다.");
	}
}

//class Police extends People{	
//	String jurisdiction; // 관할
//	String office_Position; // 직책 
//	
//	Police(){
//		super("John", "male");
//	}
//}

//class BusDriver extends People{	
//	String vehicle_Model; 
//	int bus_Number;
//	
//	BusDriver(){
//		super("Son", "male");
//	}
//}

public class Example06 {

	public static void main(String[] args) {
		Developer dev = new Developer("John-Doe", "male", "Google"); // 다른 파일에 있는 기능들의 경우 import후 쓰려는 변수나 메서드에 public으로 접근 제한자가 지정되어야 사용할 수 있다.
		Police pol = new Police();
		BusDriver bd = new BusDriver();
		
		// 참조 변수에서 데이터가 미정인 상태일 때 null
		String str = null;
//		dev = null; // 주소에 null 들어가 기존 주소를 찾아갈 수 없음
		
//		dev.language_Skill = "kotlin";
//        System.out.println(dev.name);
//		
//        dev.eatBreakfast(); // 오버라이딩 , 재정의
//        dev.eatBreakfast(11); // 오버로딩 , 이름이 같은 메서드 구분해서 사용
//		pol.eatBreakfast();
//		bd.eatBreakfast();

	}

}
