package boj_15650_N과M_2;

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
		
		perm(0);
		
		
		System.out.println(sb);
		
	}
	
	
	
	static void perm(int idx) {
		
		if (idx == M) {
			for (int i=0; i<result.length; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
			
		}
		
		
		for (int i=0; i<N; i++) {
			
			result[idx] = arr[i];
			perm(idx+1);
			
			
		}
		
	}
	
	
}