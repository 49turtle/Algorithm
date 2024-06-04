package boj_2138_전구와스위치;

import java.util.Scanner;

public class Main {

	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[] before = new int[N];
		int[] after = new int[N];
		
		String temp = sc.next();
		
		for (int i=0; i<N; i++) {	
			if (temp.charAt(i) == '0') {
				before[i] = 0;
				continue;
			}
			before[i] = 1;
		}
		
		temp = sc.next();
		
		for (int i=0; i<N; i++) {
			if (temp.charAt(i) == '0') {
				after[i] = 0;
				continue;
			}
			after[i] = 1;
		}
		
		
		
		
		
		
	}
	
	
}
