package boj_15651_N과M_3;

import java.util.List;
import java.util.Scanner;

public class Main {

	
	static int N;
	static int M;
	
	static int[] arr;
	static int[] result;
	
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
		
		
		
	}
	
	
	static void comb(int idx, int sidx) {
		
		if (sidx == M) {
			for (int i=0; i<result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if (idx == N) {
			return;
		}
		
		result[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
		
		
	}
	
	
}
