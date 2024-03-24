package boj_15652_N과M_4;

import java.util.Scanner;

public class Main {


	static int N;
	static int M;
	
	static int[] arr;
	static int[] result;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		result = new int[M];
		
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int idx, int sidx) {
		
		if (sidx == M) {
			for (int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		if (idx == N) {
			return;
		}
		
		result[sidx] = arr[idx];
		comb(idx, sidx+1);
		comb(idx+1, sidx);
		
	}
	
}