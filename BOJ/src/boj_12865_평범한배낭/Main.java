package boj_12865_평범한배낭;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	

	
	static int[] weights;
	static int[] values;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		weights = new int[N];
		values = new int[N];
		
		
		for (int i=0; i<N; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		int value = 0;
		
		

		int[][] knapsack = new int[N+1][K+1];
		
		
		for (int i=0; i<knapsack.length; i++) {
			for (int j=0; j<knapsack[i].length; j++) {
				knapsack[i][j] = -1;
			}
		}
		
		
		
		for (int i=1; i<N; i++) {
			for (int j=1; j<=K; j++) {
				
				
				if (weights[i] > j) {
					knapsack[i][j] = knapsack[i-1][j];
				}
				else {
					if (knapsack[i][j] == -1) {
						knapsack[i][j] = knapsack[i-1][j-weights[i]] + values[i];
					}
					else {
						knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-weights[i]] + values[i]);
						
					}
				}
				
			}
		}
		
		printMap(knapsack);
		
		System.out.println(knapsack[N-1][K]);
		
		
		
	}
	
	
	
	
	
	
	static void printMap(int[][] map) {

		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
