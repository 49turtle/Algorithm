package boj_14673_CrushFever;

import java.util.Scanner;

public class Main2 {
	
	static int maxScore = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		
		int[][] puzzleMap = new int[N][M];
		
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				puzzleMap[r][c] = sc.nextInt();
			}
		}
		
		
//		printMap(puzzleMap);
		
//		int cnt=0;
//		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<M; c++) {
//				if (puzzleMap[r][c] != 0) {
//					cnt++;
//					dfs(puzzleMap, r, c);
//				}
//				
//				
//			}
//		}
//		System.out.println(cnt);
		
//		dfs(puzzleMap, 0, 0);
		
//		doDfs(puzzleMap);
		
		doDfs(puzzleMap, 0, 0);
		
		
		System.out.println(maxScore);
		
		
		sc.close();
		
	}
	
	
	
	
	
	static int dfs(int[][] map, int r, int c) {
		
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		int num = map[r][c];
		map[r][c] = 0;
		
		int destroyedPuzzle = 1;
		
//		printMap(map);
//		System.out.printf("r=" +  r + ", c=" + c);
//		System.out.println();
		for (int d=0; d<4; d++) {
			if (r+dr[d] >= 0 && r+dr[d] < map.length && c+dc[d] >=0 && c+dc[d] < map[0].length && map[r+dr[d]][c+dc[d]] == num) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				destroyedPuzzle += dfs(map, nr, nc);
			}
			
		}
		
		
		return destroyedPuzzle;
	}
	
	
	
	
	
	
	static void doDfs(int[][] map, int cnt, int score) {
		if (cnt == 3) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		goDown(map);
		
		for (int r=0; r<map.length; r++) {
			for (int c=0; c<map[r].length; c++) {
				if (map[r][c] != 0) {
					
					int[][] copyMap = mapCopy(map);
							
					int num = dfs(copyMap, r, c);
					doDfs(copyMap, cnt+1, score+num*num);
					
				}
			}
		}
		
		
		
	}
	
	
	
	static void goDown(int[][] map) {
		for (int c=0; c<map[0].length; c++) {
			for (int r=map.length-1; r>=0; r--) {
				if (map[r][c] == 0) {
					int nr = r-1;
					
					while (nr>=0 && map[nr][c] == 0) {
						nr--;
					}
					
					if (nr>=0) {
						map[r][c] = map[nr][c];
						map[nr][c] = 0;
					}
					
					
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	
	static int[][] mapCopy(int[][] map) {
        int[][] copyMap = new int[map.length][map[0].length];
        
        for (int r = 0; r < map.length; r++) {
            for (int c=0; c<map[r].length; c++) {
            	copyMap[r][c] = map[r][c];
            }
        }
        
        return copyMap;
    }
	
	
	
	
	static void printMap(int[][] map) {
		
		System.out.println("---start---");
		for (int r=0; r<map.length; r++) {
			for (int c=0; c<map[r].length; c++) {
				
				System.out.print(map[r][c] + " ");
				
			}
			System.out.println();
		}
		
	}

}
