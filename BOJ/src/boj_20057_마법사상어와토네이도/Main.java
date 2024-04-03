package boj_20057_마법사상어와토네이도;

import java.util.Scanner;

public class Main {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	static int answer = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] sandMap = new int[N][N];

		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < sandMap[i].length; j++) {
				sandMap[i][j] = sc.nextInt();
				sum += sandMap[i][j];
			}
		}

		int nr = N / 2;
		int nc = N / 2;

		int d = 0;

		int dCnt = 0;

		int dChange = 0;

		int dLimit = 1;

		while (true) {
//			sandMap[nr][nc] = 1;

			nr += dr[d];
			nc += dc[d];

			dCnt++;

			if (nr == 0 && nc == -1) {
				break;
			}

			if (sandMap[nr][nc] != 0) {
				spreadSand(sandMap, nr, nc, d);
			}
//			printMap(sandMap);

			if (dCnt == dLimit) {
				d = (d + 1) % 4;
				dChange++;
				dCnt = 0;
				if (dChange == 2) {
					dLimit++;
					dChange = 0;
				}
			}

		}

		int remain = 0;
//		printMap(sandMap);
		for (int i = 0; i < sandMap.length; i++) {
			for (int j = 0; j < sandMap[i].length; j++) {
				if (sandMap[i][j] > 0) {

					remain += sandMap[i][j];
				}
			}
		}

		answer = sum - remain;
		System.out.println(answer);

	}

	static void spreadSand(int[][] sandMap, int row, int col, int dir) {

		int N = sandMap.length;

		int sand = sandMap[row][col];

		int remainSand = sand;

		int outSand = 0;

		int nr = row;
		int nc = col;

		int d = dir;

		// 정방향: d, 시계방향 90도: d-1, 반시계방향 90도: d+1

		// 1. 시계방향 90도 부분(7%, 2%) 먼저
		nr += dr[((d - 1) + 4) % 4];
		nc += dc[((d - 1) + 4) % 4];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.07);
		} else {
			outSand += (int) (sand * 0.07);
		}
		remainSand -= (int) (sand * 0.07);

		nr += dr[((d - 1) + 4) % 4];
		nc += dc[((d - 1) + 4) % 4];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.02);
		} else {
			outSand += (int) (sand * 0.02);
		}
		remainSand -= (int) (sand * 0.02);

		// 2. 반시계방향 90도 부분(7%, 2%)
		nr = row;
		nc = col;

		nr += dr[(d + 1) % 4];
		nc += dc[(d + 1) % 4];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.07);
		} else {
			outSand += (int) (sand * 0.07);
		}
		remainSand -= (int) (sand * 0.07);

		nr += dr[(d + 1) % 4];
		nc += dc[(d + 1) % 4];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.02);
		} else {
			outSand += (int) (sand * 0.02);
		}
		remainSand -= (int) (sand * 0.02);

		// 3. 10%, 1% 부분?
		// 3-1. 1%부분
		nr = row;
		nc = col;

		nr = nr + dr[((d - 1) + 4) % 4] - dr[d];
		nc = nc + dc[((d - 1) + 4) % 4] - dc[d];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.01);
		} else {
			outSand += (int) (sand * 0.01);
		}
		remainSand -= (int) (sand * 0.01);

		nr = row;
		nc = col;

		nr = nr + dr[(d + 1) % 4] - dr[d];
		nc = nc + dc[(d + 1) % 4] - dc[d];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.01);
		} else {
			outSand += (int) (sand * 0.01);
		}
		remainSand -= (int) (sand * 0.01);

		// 3-2. 10%부분
		nr = row;
		nc = col;

		nr = nr + dr[((d - 1) + 4) % 4] + dr[d];
		nc = nc + dc[((d - 1) + 4) % 4] + dc[d];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.10);
		} else {
			outSand += (int) (sand * 0.10);
		}
		remainSand -= (int) (sand * 0.10);

		nr = row;
		nc = col;

		nr = nr + dr[(d + 1) % 4] + dr[d];
		nc = nc + dc[(d + 1) % 4] + dc[d];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.10);
		} else {
			outSand += (int) (sand * 0.10);
		}
		remainSand -= (int) (sand * 0.10);

		// 4. 정방향 5%
		nr = row;
		nc = col;

		nr += 2 * dr[d];
		nc += 2 * dc[d];

		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += (int) (sand * 0.05);
		} else {
			outSand += (int) (sand * 0.05);
		}
		remainSand -= (int) (sand * 0.05);

		// 4-2. 정방향 alpha

		nr = row;
		nc = col;

		nr += dr[d];
		nc += dc[d];

		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			sandMap[nr][nc] += remainSand;
		} else {
			outSand += remainSand;
		}

		//
		sandMap[row][col] = 0;
//		answer += outSand;
//		System.out.println("sandOUT: " + outSand + ", remain: " + remainSand);

	}

	static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---end---");
	}

}
