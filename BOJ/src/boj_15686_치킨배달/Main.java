package boj_15686_치킨배달;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	static int N;
	static int M;
	
	static int[][] map;
	
	static List<Integer> chicken;
	static List<Integer> house;
	
	
	static int[] sel;
	
	static int ans;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				int num = sc.nextInt();
				
				map[r][c] = num;
				
				if (num == 2) {
					chicken.add(r*N+c);
				}
				else if (num == 1) {
					house.add(r*N+c);
				}
			}
		}
		
		
		sel = new int[M];
		
		comb(0, 0);
		
		
		
		
		
		
		
	}
	
	static int calcDist() {
		for (int i=0; i<M; i++) {
			
		}
		
		
		return 0;
	}
	
	
	
	
	static void comb(int idx, int sidx) {
		
		if (sidx == M) {
			
			// 정답 갱신
			return;
			
		}
		
		if (idx == chicken.size()) {
			return;
		}
		
		
		comb(idx+1, sidx);
		sel[sidx] = chicken.get(idx);
		comb(idx+1, sidx+1);
		
		
	}
	
	
	

}
