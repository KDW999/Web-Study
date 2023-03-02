package chapter04;

import java.util.*;

public class Sample01 {

	public static void main(String[] args) {

		Random rd = new Random();
		// 로또 번호를 저장할 배열
//		int[] lottoList1 = new int[6];
//
//		 
//		for (int i = 0; i < lottoList1.length; i++) {
//			boolean flag = false;
//			
//			int lotto = rd.nextInt(45) + 1;	
//			
//			for(int j=0; j<lottoList1.length; j++) { // 중복 값 거르기
//				if(lottoList1[j] == lotto) {
//					flag = true;
//					break;
//				}
//			}
//			
//			if(flag) {
//				i--;
//				continue;
//				}
//			lottoList1[i] = lotto;
//		}
//		
//		for(int lotto: lottoList1) System.out.println(lotto);
		
		Set<Integer> lottoList2 = new TreeSet<Integer>(); // TreeSet은 들어간 숫자를 중복을 거르고 정렬해준다.
		while(lottoList2.size() < 6) {
			lottoList2.add(rd.nextInt(45)+1);
		}
		for(int lotto: lottoList2) System.out.println(lotto);
	}

}
