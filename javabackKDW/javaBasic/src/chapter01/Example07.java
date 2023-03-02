package chapter01;


public class Example07 {

	public static void main(String[] args) {
		// 제어문 (반복) while
		boolean flag = true;
		int n = 0;
//		
//		while(flag) {
//			System.out.println("Loop" + n++);
			
//			n = n+1;
//			n +=1;
//			n++;
//			if(n == 10) {
//				flag = false;
//			}
			 
//			flag = n != 10; // flag를 false로 만드는 다른 방법
//		}
		
		
//		System.out.println("flag : " + flag);
		
		// 제어문 (반복) do while
//		do {
//			System.out.println("Do While Loop!");
//		}while(flag);

		// Continue, Break
		n = 0;
//		while(true) {
//			if(n++ % 3 ==0) { // continue에서 변수에 변경을 걸어주자 무한루프에 빠지기 싫으면
//				System.out.println("Continue!");
//				continue;
//			}
//			if(n > 10) {
//				System.out.println("Break!");
//				break;
//			}
//			
//			System.out.println(n++);
//		}
		for(int i=1; i<=3; i++) {
			if(i==2) continue; 
			System.out.println(i);
		}
		System.out.println("Out of Loop");
	}

}
