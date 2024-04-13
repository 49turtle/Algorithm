package boj_11048_이동하기;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	
	static int[][] map;
	
	static int[][] dp;
	
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		dp = new int[N][M];
		dp[0][0] = map[0][0];
		
		for (int i=1; i<N; i++) {
			dp[i][0] = map[i][0] + dp[i-1][0];
		}
		for (int i=1; i<M; i++) {
			dp[0][i] = map[0][i] + dp[0][i-1];
		}
		
		for (int r=1; r<N; r++) {
			for (int c=1; c<M; c++) {
				dp[r][c] = map[r][c] + Math.max(dp[r-1][c], dp[r][c-1]);
			}
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}
	
	
}
