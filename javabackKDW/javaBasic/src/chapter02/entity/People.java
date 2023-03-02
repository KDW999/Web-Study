package chapter02.entity;

public class People{
	public String name;
	int age;
	String gender;
	String address;
	String email;
	
	People(String name, String gender){ // 상위 클래스에 생성자가 있다면 하위 클래스에도 생성자를 만들어주어야 한다
		this.name = name;
		this.gender = gender;
	}
	
	public void eatBreakfast() {
		System.out.println("7시에 아침을 먹습니다.");
	}
}