package swea_1970_쉬운거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] money = { 10, 50, 100, 500, 1000, 5000, 10000, 50000 };

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt() / 10;
			
			
			int[] dp = new int[N+1];
			
			
			for (int i=1; i<=N; i++) {
				
				
				for (int m=0; m<money.length; m++) {
					int minCnt = 987654321;
					if (i >= money[m] / 10) {
						minCnt = Math.min(minCnt, dp[i-money[m] / 10] + 1);
					}
					dp[i] = minCnt;
				}
				
				
			}
			
			
			
			System.out.println(Arrays.toString(dp));
			
			
			
			
			
			
			
		}
		
		
		
		
	}
		
}
