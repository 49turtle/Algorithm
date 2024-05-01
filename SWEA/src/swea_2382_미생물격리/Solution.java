package swea_2382_미생물격리;

import java.util.Scanner;

public class Solution {

	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	static int N;
	static int M;
	static int K;
	
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i=0; i<K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int micro = sc.nextInt();
				int dir = sc.nextInt();
				
			}
			
			
			
			
			
		}
		
		
	}
	
	public static void move(int row, int col, int micro, int dir) {
		
		
	}
	
	
}
