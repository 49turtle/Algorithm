package boj_15656_N과M_7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	
	static int[] arr;
	static int[] sel;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		sel = new int[M];
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		
		comb(0, 0);
		
		System.out.println(sb);
		
		
	}
	
	
	static void comb(int idx, int sidx) {
		
		if (sidx == M) {
			for (int i=0; i<M; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		if (idx == N) {
			return;
		}
		
		sel[sidx] = arr[idx];
		comb(idx, sidx+1);
		comb(idx+1, sidx);
		
		
	}
	
	
}