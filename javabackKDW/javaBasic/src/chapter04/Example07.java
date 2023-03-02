package chapter04;

class Ticketing{
	static int ticketVol = 1;
	
	// synchronized 키워드로 해당 메서드를 동기 메서드로 지정 
	// 한 스레드가 해당 메서드를 작업 중일 땐 접근 막음
	public static synchronized void ticketing() {
		
		if(ticketVol > 0) {
			System.out.println(Thread.currentThread().getName() + " - 티켓팅");
			ticketVol--;
		}
		else {
			System.out.println(Thread.currentThread().getName() + " - 티켓팅 실패");
		}
		
		System.out.println(Thread.currentThread().getName() + " - 티켓팅 시도 후 티켓 수 : " + ticketVol);
	}
}

class TicketingThread implements Runnable{
	
	
	public void run() {
		Ticketing.ticketing();
	}
}

public class Example07 {
	public static void main(String[] args) {
		TicketingThread tkr = new TicketingThread();
		Thread th1 = new Thread(tkr, "A");
		Thread th2 = new Thread(tkr, "B");
		Thread th3 = new Thread(tkr, "C");
		
		th1.start();
		th2.start();
		th3.start();

	}

}
