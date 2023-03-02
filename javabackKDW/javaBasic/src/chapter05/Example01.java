package chapter05;

import java.util.*;

import chapter02.entity.Developer;

class MyInfo<JI, TMP>{
	String name;
	String job;
	// 직업의 정보
	JI jobInfo;
	TMP tmp;
	
	// 제네릭 메서드
	<T, TMP>void getTmpList(List<T> list, TMP tmp) {
		
	}
}


public class Example01 {

	public static void main(String[] args) {
		// 제네릭
		// 다양한 타입을 다루는 클래스 혹은 메서드에서 타입을 지정해 주는 것
		List strList = new ArrayList();
		strList.add("기본 문자열");
//		String str = (String)strList.get(0); // SOLID 원칙에 어긋난다. 최상위 클래스 object(부모)가 String(자식)이 된다는 꼴 / 강제 형 변환하면 사용은 가능함
		// 제네릭을 사용하지 않으면 매 번 형변환 작업을 해줘야 함
		
		List<String> strList2 = new ArrayList<>();
		strList2.add("기본 문자열2");
		
		// 제네릭을 사용하면 다루는 데이터의 데이터 타입을 알고 있기에 형변환 X
		String str2 = strList2.get(0);

		MyInfo mi = new MyInfo();
		mi.jobInfo = new Developer();
		Developer dev = (Developer)mi.jobInfo;
		System.out.println(mi.jobInfo);
		
		MyInfo<Developer, Integer> mi2 = new MyInfo<Developer, Integer>();
		mi2.jobInfo = new Developer();
		Developer developer2 = mi2.jobInfo;
		
		// 제너릭 클래스의 타입 변수는
		// 선언 시 다형성이 적용되지 않기에 
		// 선언 시 사용한 타입변수와 생성 시 사용하는 타입변수가 같아야 함
//		MyInfo<Object, Object> mi3 = new MyInfo<Developer, Integer>();
		
		// ? 키워드로 타입변수의 다형성 적용
		MyInfo<?, ?> mi4 = new MyInfo<Developer, Integer>();
		
	}

}
