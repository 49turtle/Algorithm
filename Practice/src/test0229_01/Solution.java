package test0229_01;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] score = new int[N];
			
			for (int i=0; i<N; i++) {
				score[i] = sc.nextInt();
			}
			
			
			Arrays.sort(score);

			
			int answer = 0;
			
			for (int i=N-1; i>=N-K; i--) {
				answer += score[i];
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		
			
		}
		
		
		sc.close();
		
		
	}
	
	
}
