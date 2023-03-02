package chapter01;

import java.util.*;

public class Example05 {

	public static void main(String[] args) {
		// 제어문(조건) switch
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		switch (n) {

		case 1:
			System.out.println("1을 더합니다.");
			System.out.println(n += 1);
			return;
		case 2:
			System.out.println("2를 곱합니다.");
			System.out.println(n *= 2);
		case 3:
			System.out.println("3을 나눕니다.");
			System.out.println(n /= 3);
		default:
			System.out.println("1증가 시킵니다.");
			System.out.println(++n);

		}

	}

}
