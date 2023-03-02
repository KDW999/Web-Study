package algorhitm;

import java.util.*;

public class Swea {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i < T; i++) {
			int[] arr = new int[10];
			for(int j=0; j<10; j++) arr[j] = sc.nextInt();
			
			Arrays.sort(arr);
			
			double sum = 0;
			
			for(int k=1; k<9; k++) {
				sum += arr[k];
			}
			System.out.println(sum / 8);
			double FloatArrAvr = Math.round(sum / 8);
            System.out.println(FloatArrAvr);
			int arrAvr = (int)FloatArrAvr;
			System.out.println("#" + (i+1) + " " + arrAvr);
		}
	}
}
