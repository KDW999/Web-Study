package chapter02;

// class : 객체를 생성하는 설계도 / 기준
class SmartPhone {
	
	// 멤버 변수, 속성
	String nation;
	String os;
	String owner;
	String telNumber;
	
	
	// 메서드, 함수
	void tel(String toTelNumber) {
		// 전화번호가 빈값이면 '전화번호를 입력하세요.'
		if(toTelNumber.isEmpty()) {
			System.out.println("전화번호를 입력하세요.");
	        return;
		}
		// 빈값이 아니면 'toTelNumber에 전화중입니다.'
		System.out.println(toTelNumber+"에 전화중입니다.");
	}
	void sendMessage(String toTelNumber, String message) {
		System.out.println(toTelNumber + "에 " + message + "를 보냅니다");
	}
}

public class Example01 {

	public static void main(String[] args) {
		// 인스턴스 선언 및 생성
		SmartPhone myPhone; // 인스턴스 선언, myPhone은 참조변수, 생성하는 걸 인스턴스화라고 한다.
		myPhone = new SmartPhone(); // 인스턴스 생성, new를 찍을 때는 무언가를 생성한다는 의미, 스마트폰을 샀을 때 딱 공기계의 상태
		SmartPhone yourPhone = new SmartPhone();
		
		                    // 변수는 접근
//		myPhone.tel("dd"); // 메서드 호출
//		myPhone.sendMessage(null, null);
//		System.out.println(myPhone.tel("ds"));
//		System.out.println(yourPhone.os);
		
		// 인스턴스의 속성(멤버 변수)에 접근, 스마트폰을 사서 개통까지 한 상태
		myPhone.nation = "Korea";
		myPhone.os = "Android";
		myPhone.owner = "김동우";
		myPhone.telNumber = "010-1234-5678";
		
		System.out.println(myPhone.nation);
		System.out.println(myPhone.os);
		System.out.println(myPhone.owner);
		System.out.println(myPhone.telNumber);
		
		// 인스턴스의 기능을 사용(메서드를 호출)
		myPhone.tel("010-2222-2222");
		
//		SmartPhone hisPhone = new String();
		SmartPhone hisPhone = new SmartPhone();
		hisPhone.nation = "USA";
		System.out.println(hisPhone.nation);
		
		System.out.println("=====================");
		System.out.println("yourPhone " + yourPhone);
		System.out.println("hisPhone " + hisPhone);
		hisPhone = yourPhone; // hisPhone이 바라보던 메모리 주소가 yourPhone의 메모리 주소를 바라본다. , hisPhone이 yourPhone을 바라본다고 기존의 hisPhone의 메모리가 사라지는 건 아니다.
		System.out.println("yourPhone " + yourPhone);
		System.out.println("hisPhone " + hisPhone); 
		System.out.println("=====================");
		
		yourPhone.nation = "UK";
		System.out.println(hisPhone.nation);
		
//		int a =10;
//		int b = a;
//		
//		System.out.println(b);
//		a = 12;
//		System.out.println(b);
		
		//인스턴스 선언 없이 사용할 경우
//		String mynation;
//		String myos;
//		String myowner;
//		String mytelNumber;
//		
//		String yournation;
//		String youros;
//		String yourowner;
//		String yourtelNumber;

	}

}
