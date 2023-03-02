package chapter03;

// public : 클래스, 메서드 주로 사용
// private : 멤버 변수 주로 사용
public class Modifier {

	private String name;
	private String address;
	private String telNumber;
	
	// priavte으로 선언된 멤버변수를 초기화하기 위한
	// 첫번째 방법 : 생성자를 이용
	// 생성자를 이용한 방법은 인스터스 생성 때만 멤버 변수(modifier 생성자 내 변수) 초기화
	public Modifier(String name, String address, String telNumber) {
		this.name = name;
 		this.address = address;
 		this.telNumber = telNumber;
 		System.out.println(this.name +" " + this.address +" " + this.telNumber);
	}
	
	// 두번째 방법 : Setter 메서드 이용
	public void setName(String name) {
		this.name = name;
	}
	 
	// 외부에서 멤버변수에 접근하기 위한 방법
	// Getter 메서드 이용
	public String getName() {
		return this.name;
	}
}
