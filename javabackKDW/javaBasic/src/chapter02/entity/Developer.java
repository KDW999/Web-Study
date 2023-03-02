package chapter02.entity;

//상속을 사용하는 이유
public class Developer{	

	public String language_Skill;
	String company;
	String developer_Position;
	

//	public Developer(String name, String gender, String comapny){
//		// super() : 슈퍼 클래스의 생성자
//		// super는 상위 클래스에 있는 선언된 변수, 메서드를 그대로 사용하게 해준다
//		super(name, gender); // 하위 클래스에서 상위 클래스 생성자를 호출할 땐 super를 붙이고 매개변수를 적어준다.
//		this.company = company;
//	}
	
//	public void eatBreakfast(int time) { // 부모 클래스에 있던 메서드를 자식 클래스에서 재정의 -> 오버라이딩 / 반환타입, 이름, 매개변수 같아야 됨
//		System.out.println(super.name + "은 "+ time+"시에 아침 밥 먹습니다.");
//	}
}