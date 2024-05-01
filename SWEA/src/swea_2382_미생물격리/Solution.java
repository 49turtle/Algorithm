package swea_2382_미생물격리;

import java.util.Scanner;

public class Solution {

	// "",상,하,좌,우
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	static int N;
	static int M;
	static int K;

	static int[][] map;
	static int[][] dirMap;

	static int[][] decideDir;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][N];
			dirMap = new int[N][N];

			for (int i = 0; i < K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int micro = sc.nextInt();
				int dir = sc.nextInt();

				map[row][col] = micro;
				dirMap[row][col] = dir;

			}
			int cnt = 0;
			while (cnt < M) {
				cnt++;
				int[][] tempMap = new int[N][N];
				int[][] tempDirMap = new int[N][N];

				decideDir = new int[N][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] > 0) {
							move(r, c, tempMap, tempDirMap);
						}
					}
				}

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						map[r][c] = tempMap[r][c];
						dirMap[r][c] = tempDirMap[r][c];
					}
				}

//			    printMap(map);
//			    printMap(dirMap);
			}

			int ans = 0;

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					ans += map[r][c];
				}
			}

			System.out.println("#" + test_case + " " + ans);

		}

	}

	public static void move(int row, int col, int[][] tempMap, int[][] tempDirMap) {

		int dir = dirMap[row][col];
		int micro = map[row][col];

		int nr = row + dr[dir];
		int nc = col + dc[dir];

		if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {

			if (dir == 1) {
				dir = 2;
			} else if (dir == 2) {
				dir = 1;
			} else if (dir == 3) {
				dir = 4;
			} else {
				dir = 3;
			}
			micro /= 2;

		}

		tempMap[nr][nc] += micro;
		if (tempMap[nr][nc] == micro) {
			tempDirMap[nr][nc] = dir;
		} else {
			if (micro > tempMap[nr][nc] - micro) {
				tempDirMap[nr][nc] = dir;
			}
		}

	}

	public static void printMap(int[][] map) {
		System.out.println("---start---");
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
