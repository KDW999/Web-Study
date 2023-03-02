package chapter03;

class Animal {
	 String ears;
	 String eyes;
	 String legs;
}

class Bird extends Animal {
	 String wings;
}

class Monkey extends Animal {
	 String arms;
	 
	 Monkey(){}
	 Monkey(String arms, String eyes, String ears, String legs){
		 
		 super.ears = ears; // 상위 클래스 변수
		 super.eyes = eyes;
		 super.legs = legs;
		 this.arms = arms; // 자기 클래스 변수
	 }
	 
}

public class Polymorphism {

	public static void main(String[] args) {
		Animal bird = new Bird();
		bird.ears = "ears";
		bird.eyes = "eyes";
		bird.legs = "legs";
//		bird.wings = "wings";
		
		Bird bird2 = (Bird)bird; // Animal 타입이던 bird를 Bird로 변환시킴
		bird2.wings = "wings";
		
		Monkey monkey1 = new Monkey("arms2", "eyes", "ears", "legs");
		System.out.println(monkey1);
		System.out.println(monkey1.arms + " / "+ monkey1.eyes+ " / " + monkey1.ears+ " / " + monkey1.legs);
		
		Animal animal1 = monkey1; // monkey1의 주소를 animal1에 넣은 것 뿐 monkey1의 값에 변함은 없다
		System.out.println(animal1); // 주소 같음 대신 animal에서 arms가 하위 변수라 인식을 못함
		System.out.println(animal1.eyes + animal1.ears + animal1.legs); // 주소를 받았기에 animal1에서 monkey에서 선언된 변수들을 사용 가능
	    
		System.out.println(animal1 instanceof Monkey); // 
		System.out.println(animal1 instanceof Animal);
		
		Monkey monkey2 = (Monkey)animal1; // animal1의 주소를 monkey2에 대입
		System.out.println(monkey2);
		System.out.println(monkey2.arms +monkey2.eyes + monkey2.ears + monkey2.legs); // animal에서 arms를 쓸 수 없게됐다고 기존에 있던 arms가 사라지는 건 아님
		
		System.out.println(animal1 instanceof Bird);
	
	}
}
