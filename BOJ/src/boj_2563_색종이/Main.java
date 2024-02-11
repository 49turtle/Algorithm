package boj_2563_색종이;

import java.util.Scanner;

public class Main {
	
	static int[][] paper = new int[101][101];
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		
		
		for (int n=0; n<N; n++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			coloredArea(x, y);
			
			
		}
		
		int answer = 0;
		
		for (int i=0; i<paper.length; i++) {
			for (int j=0; j<paper[0].length; j++) {
				answer += paper[i][j];
			}
		}
		
		System.out.println(answer);
		sc.close();
		
		
	}
	
	
	
	public static void coloredArea(int x, int y) {
		
		for (int i=x; i<x+10; i++) {
			for (int j=y; j<y+10; j++) {
				if (paper[i][j] != 1) {
					paper[i][j] = 1;
				}
			}
		}
		
		
	}
	

}
