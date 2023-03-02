package chapter02;

class Manufacturer{ // class를 사용자 지정 타입으로 쓸 수 있다.
	// 제조사명
	String name;
	// 제조 국가
	String country;
	// 제조사 홈페이지 주소
	String webUrl;
	
	int i = 0;
	void print() {
		System.out.println("name : " + name + " / country : "+ country + " / webUrl :" + webUrl);
		i++;
		if(i >10) return;
		print(); // 재귀호출은 다른 방법이 있나 최대한 생각하고 정 없으면 쓰자, 데이터 누적 떄문에 웬만하면 안쓰는게 좋다.
	}
}

class Car {
	// 제조사
	String manufacturer;
	// 외장컬러
	String exteriorColor;
	// 내장컬러
	String interiorColor;
	// 모델명
	String modelName;
	
	// Manuefacturer 타입 반환 , int 타입 반환하듯
	Manufacturer create(String name, String country, String webUrl) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.name = name; // 주소 찾아가서 현대 저장, 참조 매개변수는 read & write라 메소드 내에서 값을 저장하면 메인 메소드로 돌아가도 값이 변경된 채로 남아있다.
		manufacturer.country = country; // 주소 찾아가서 KR 저장, 주소를 찾아가서 값을 변경해버림
		manufacturer.webUrl = webUrl; // 인스턴스 매개변수는 메서드 내에서 값을 변경해도 원본(메인 메소드에 있던 변수)에 영향을 미치지 않는다.
		
		System.out.println(manufacturer);
		
		return manufacturer; // new Manufacturer();를 반환
	}
	
}

public class Example04 {

	public static void main(String[] args) {

		Car myCar = new Car();
		Manufacturer manufacturer = myCar.create("현대", "KR", "hyundai.com"); // 인자를 주고 호출 후, new Manufacturer();를 반환받음
		                                                                     // 반환되는 과정에서 메서드 내에선 이미 변수들에 값이 들어가져있음
		System.out.println("========");
		System.out.println(manufacturer);
		System.out.println(manufacturer.name); // 메서드 내에서 주소를 찾아가 값을 이미 넣어줬기 때문에 출력하면 내가 인자로 줬던 현대가 출력된다.
		System.out.println("========");
		manufacturer.print();
		
	}

}
