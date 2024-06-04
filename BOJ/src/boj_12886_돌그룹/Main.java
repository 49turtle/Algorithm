package boj_12886_돌그룹;

import java.util.Scanner;

public class Main {
	
	
	static int total;
	
	static boolean[][] visited;
	
	static boolean flag;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		total = A + B + C;
		
		flag = false;
		visited = new boolean[1501][1501];
		
		if (total % 3 == 0) {			
			grouping(A, B);
			grouping(B, C);
			grouping(A, C);
		}
		
		
		if (flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}
	
	static void grouping(int a, int b) {

		if (a == b) {
			if (a == total/3) {
				flag = true;
				return;
			}
			else {
				visited[a][b] = true;
				grouping(a, total - a - b);
			}
		}
		
		if (flag || visited[a][b] || visited[b][a]) {
			return;
		}

		
		else {
			
			if (!visited[a][b] || !visited[b][a]) {
				
				visited[a][b] = true;
				visited[b][a] = true;
				
				
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				
				
				int nA = min + min;
				int nB = max - min;
				int nC = total - nA - nB;
				
				grouping(nA, nB);
				grouping(nA, nC);
				grouping(nB, nC);
				
				
				
				
			}	
		}
	}
	
	
	
	
	

}
