package swea_2115_벌꿀채취;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int C;
	
	static int[][] map;
	
	static List<Integer> profitList;
	

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			int sumMax = -1;
			
			int profit1 = 0;
			int profit2 = 0;
			
			
			for (int i=0; i<N-1; i++) {
				for (int j=0; j<N; j++) {

					int max1 = -1;
					int max2 = -1;
					
					for (int k=0; k<=N-M; k++) {
						profit1 = calcProfit(i, k);
						if (profit1 > max1) {
							max1 = profit1;
						}
					}
					
					for (int k=0; k<=N-M; k++) {
						profit2 = calcProfit(j, k);
						if (profit2 > max2) {
							max2 = profit2;
						}
					}
					
					
				}
			}
			
			
			
			
			for(int i=0; i<N-1; i++) {
				
				
				int max1 = -1;
				int max2 = -1;
				
				
				for (int k=0; k<=N-M; k++) {
					profit1 = calcProfit(i, k);
					if (profit1 > max1) {
						max1 = profit1;
					}
				}
				
				for (int j=i+1; j<N; j++) {
					
					for (int k=0; k<=N-M; k++) {
						profit2 = calcProfit(j, k);
						if (profit2 > max2) {
							max2 = profit2;
						}
					}
				}
				if (max1 + max2 > sumMax) {
					sumMax = max1 + max2;
				}
			}
			
			if (M+M <= N) {
				for (int row=0; row<N; row++) {
					for (int i=0; i<=N-2*M; i++) {
						for (int j=i+M; j<=N-M; j++) {
							
							
							profit1 = calcProfit(row, i);
							profit2 = calcProfit(row, j);
							
							if (profit1 + profit2 > sumMax) {
								sumMax = profit1 + profit2;
							}
							
						}
					}
				}
			}
			
			
			
			
			
			System.out.printf("#%d %d\n", test_case, sumMax);
			
			
			
		}
		
		
		
		sc.close();
		
	}
	
	
	static int calcProfit(int row, int col) {
		
		
		int[] honey = new int[M];
		for (int i=0; i<M; i++) {
			honey[i] = map[row][col+i];
		}
		
		
		profitList = new ArrayList<Integer>();
		combination(honey, 0, 0, 0);
		int max = -1;
		for (int i=0; i<profitList.size(); i++) {
			if (profitList.get(i) > max) {
				max = profitList.get(i);
			}
		}
		
		return max;
	}


	private static void combination(int[] honey, int idx, int profit, int limit) {
		
		if (idx >= honey.length) {
			profitList.add(profit);
			return;
		}
		
		combination(honey, idx+1, profit, limit);
		if (honey[idx] + limit <= C) {
 			combination(honey, idx+1, profit+honey[idx]*honey[idx], limit+honey[idx]);
		}
		
	}
	
	
	
	
	
}
