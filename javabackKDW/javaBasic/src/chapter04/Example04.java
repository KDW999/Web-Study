package chapter04;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Batch1 extends TimerTask{
	
	public void run() {
		System.out.println("Batch1 동작");
	}
}

class Batch2 extends TimerTask{
	
	public void run() {
		System.out.println("Batch2 동작");
	}
}



public class Example04 {

	public static void main(String[] args) {
		
		// 시스템 시간
//		long currentTimeLillis = System.currentTimeMillis();
//		System.out.println(currentTimeLillis);
//		
//		// Calendar class
//		// 날짜 관련된 java.util package
//		Calendar calendar = Calendar.getInstance();
//		Calendar calendar2 = new GregorianCalendar();
//		
//		System.out.println(calendar);
//		System.out.println(calendar2);
//		
//		// 연도
//		System.out.println(calendar.get(calendar.YEAR));
//		// 월 (Calendar 클래스는 1월 = 0)
//		System.out.println(calendar.get(calendar.MONTH));
//        // 일		
//		System.out.println(calendar.get(calendar.DATE));
//		// 요일
//		System.out.println(calendar.get(calendar.DAY_OF_WEEK));
//		if(calendar.get(calendar.DAY_OF_WEEK) == 4) System.out.println("수요일");
//		
//		calendar2.set(2002, 11, 25);
//		System.out.println(calendar2);
//		
//		// 밀리초 단위를 시간, 분, 초
//		int millToHours = 32400000 / (3600 * 1000);
//		System.out.println(millToHours);
//		
//		// java.util package의 Date 클래스
//		Date date = new Date();
//		
//		// java.util package의 simpleDateFormat 클래스
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("dd. MM. yyyy. HH:mm:ss");
//		System.out.println(sdf.format(date));
//		System.out.println(sdf2.format(date));
//		
//		// Date 클래스와 Calendar 클래스의 단점을 보완한
//		// java.time package의 클래스
//		LocalDate localDate = LocalDate.now();
//		System.out.println(localDate.toString());
//		LocalTime localTime = LocalTime.now();
//		System.out.println(localTime.toString());
//		LocalDateTime localdatetime = LocalDateTime.now();
//		System.out.println(localdatetime.toString());
//		LocalDateTime localDateTimeOf = LocalDateTime.of(2022, 12, 25, 3, 17);
//		System.out.println(localDateTimeOf);
//		
//		System.out.println(localdatetime.getMonth()+" 1월");
//		System.out.println(localDate.isLeapYear());
//		
//		localdatetime.minusYears(10).plusMonths(5);
//		
//		// TimerTask
//		Batch1 b1 = new Batch1();
//		Batch2 b2 = new Batch2();
//		
//		Timer timer = new Timer(true);
//		timer.schedule(b1, 5000);
//		timer.schedule(b2, 3000);
//		
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//			System.out.println("오류요");
//		}
		
		// Decimal Text format
		DecimalFormat decimalFormat = new DecimalFormat("##,###.00");
		System.out.println(decimalFormat.format(50000));
	}

}
