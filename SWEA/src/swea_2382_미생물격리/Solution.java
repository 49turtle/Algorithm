package swea_2382_미생물격리;

import java.util.Scanner;

public class Solution {

	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	static int N;
	static int M;
	static int K;
	
	static int[][] map;
	static int[][] dirMap;
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			dirMap = new int[N][N];
			
			for (int i=0; i<K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int micro = sc.nextInt();
				int dir = sc.nextInt() - 1;
				
				map[row][col] = micro;
				dirMap[row][col] = dir;
				
			}
			int cnt = 0;
			
			while (cnt < M) {
//				printMap(map);
				cnt++;
				int[][] tempMap = new int[N][N];
				visited = new boolean[N][N];
				for (int r=0; r<map.length; r++) {
					for (int c=0; c<map[r].length; c++) {
						if (map[r][c] > 0) {
							tempMap = move(r, c, tempMap);
							printMap(tempMap);
							printMap(dirMap);
						}
					}
				}
				
				for (int r=0; r<map.length; r++) {
					for (int c=0; c<map[r].length; c++) {
						map[r][c] = tempMap[r][c];
					}
				}
				
				
			}
			
			int ans = 0;
			
			for (int r=0; r<map.length; r++) {
				for (int c=0; c<map[r].length; c++) {
					ans += map[r][c];
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
			
			
			
			
		}
		
		
	}
	
	public static int[][] move(int row, int col, int[][] tempMap) {
		
		int dir = dirMap[row][col];
		int micro = map[row][col];
		
		
		
		int nr = row + dr[dir];
		int nc = col + dc[dir];
		
		if (nr == 0 || nc == 0) {
			
			if (dir == 0) {
				dir = 1;
			}
			else if (dir == 1) {
				dir = 0;
			}
			else if (dir == 2) {
				dir = 3;
			}
			else {
				 dir = 2;
			}
			
			micro /= 2;
			if (micro == 0) {
				map[row][col] = 0;
				dirMap[row][col] = 0;
				return tempMap;
			}
		}
		
		// 만약 이동한 위치에 미생물이 이미 존재했다면?
		if (tempMap[nr][nc] > 0 && !visited[nr][nc]) {
			for (int d=0; d<4; d++) {
				int nnr = nr+dr[d];
				int nnc = nc+dc[d];
				int maxMicro = micro;
				if (nnr >= 0 && nnr < N && nnc >= 0 && nnc < N && map[nnr][nnc]>maxMicro) {
					maxMicro = map[nnr][nnc];
					dirMap[nr][nc] = dirMap[nnr][nnc];
					visited[nr][nc] = true;
				}
			}
		}
		
		
		
		
		// 초기화
		map[row][col] = 0;
		dirMap[row][col] = 0;
		
		tempMap[nr][nc] += micro;
		
		
		return tempMap;
		
		
	}
	
	
	
	public static void printMap(int[][] map) {

		System.out.println("---start---");
		for (int r=0; r<map.length; r++) {
			for (int c=0; c<map[r].length; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		}
	}
	
	
}
