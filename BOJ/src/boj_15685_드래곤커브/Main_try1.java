package boj_15685_드래곤커브;

import java.util.Scanner;

public class Main_try1 {

	static boolean[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		map = new boolean[10][10];
		
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			doCurve(g, x, y, d);


			System.out.println("--------------------");
			
		}
		
		
		
		
		
		sc.close();
	}
	
	
	static int[] doCurve(int gen, int r, int c, int d) {
		printArr(map);
		int[] dr = {0, -1, 0, 1};
		int[] dc = {1, 0, -1, 0};
		
		int nr = r;
		int nc = c;
		map[nr][nc] = true;
		
		if (gen==0) {
			nr += dr[d];
			nc += dc[d];
			map[nr][nc] = true;
			return new int[] {nr, nc};
		}
		
		if (gen==1) {
			int[] now = doCurve(gen-1, r, c, d);
			doCurve(gen-1, now[0], now[1], (d+1)%4);
		}

		int[] now = doCurve(gen-1, r, c, d);
		return doCurve(gen-1, now[0], now[1], (d+2)%4);
		
	}
	
	
	public static void printArr(boolean[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				if (arr[i][j]) {
					System.out.print(1 + " ");
				}
				else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}
	
	
	
}
