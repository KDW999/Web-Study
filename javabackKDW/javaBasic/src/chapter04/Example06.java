package chapter04;

// Thread 클래스를 상속받아서 Thread 만드는 방법
class Thread1 extends Thread {

	// run을 Override해서 작업할 내용을 구현
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print("*");
			// Thread.yield() : 자신의 시간을 
			// 다음 순번의 Thread에 양보
			Thread.yield();
			for(int j=0; j<100001; j++) {}
		}
	}
}

// Runnable 인터페이스를 구현해서 Thread 만드는 방법
class Thread2 implements Runnable {

	// Runnable 인터페이스의 추상 메서드 run()을 구현
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print("#");
			for(int j=0; j<100001; j++) {}
		}
	}
}

class CountDown extends Thread {
	public void run() {
		// Thread.slee()은 지정 시간동안 
		// 해당 스레드를 Blocked 상태로 만듦
		for(int i=15; i>0; i--) {
			System.out.println(i+ "초...");
			try {
				// 해당 스레드를 1초 동안 Blocked 상태로 만듦
				// Blocked 상태 : 실행 중이지만 CPU 스케줄러에 선택은 받지 못하는 상태
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("카운트 끝");
	}
}

public class Example06 {
	public static void main(String[] args) {
		Thread1 th1 = new Thread1(); // Thread 클래스를 상속한 방법은 인스턴스 생성 후 바로 사용 가능

		// Runnable 인터페이스를 구현한 클래스의 경우
		// Thread 클래스의 생성자의 인자로 담아서 Thread 인스턴스를 생성 후 사용 가능
		Thread2 th2 = new Thread2();
		Thread th = new Thread(th2);

		// 우선순위를 지정하지 않으면 기본값 5가짐
		// Thread 클래스의 우선순위 지정
		th1.setPriority(1);
		th.setPriority(9);
		
		// 상속받은 Thread 클래스의 start() 메서드로 해당 Thread를 실행
		th1.start();
		
		try {
			th1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		th.start();
		
		try {
			th.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
//
//		for (int i = 0; i < 20; i++) {
//			System.out.print("@");
//			for(int j=0; j<100001; j++) {}
//		}
		
//		CountDown cd = new CountDown();
//		cd.start();	
	}

}
