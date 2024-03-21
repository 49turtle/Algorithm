package boj_14673_CrushFever;

import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	
	static int[][] puzzle;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	static int popPuzzleNum;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		puzzle = new int[N][M];
		int[][] puzzleCopy = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				puzzle[i][j] = sc.nextInt();
				puzzleCopy[i][j] = puzzle[i][j];
			}
		}
		
		
		
		int answer = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				
				if (puzzle[r][c] != 0) {
					popPuzzleNum = 0;
					dfs(r, c);
					goDown();
				}
				answer += popPuzzleNum * popPuzzleNum;
				
			}
		}
				
		
		
		
		
		
		
		
		sc.close();
		
		
	}
	
	
	static void dfs(int r, int c) {
		
		int nr = r;
		int nc = c;
		
		puzzle[nr][nc] = 0;
		popPuzzleNum++;
		
		for (int d=0; d<4; d++) {
			nr += dr[d];
			nc += dc[d];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && puzzle[nr][nc] == puzzle[r][c]) {
				dfs(nr, nc);
			}
			
		}
		
		
		
		
	}
	
	
	static void goDown() {
		
		for (int i=0; i<M; i++) {
			int zeroCnt = 0;
			for (int j=N-1; j>=0; j--) {
				if (puzzle[j][i] == 0) {
					zeroCnt++;
				}
				else {
					if (zeroCnt > 0) {
						puzzle[j+zeroCnt][i] = puzzle[j][i];
						puzzle[j][i] = 0;
					}
					
				}
			}
			

			
			
		}
		
		
	}
	
	

}
