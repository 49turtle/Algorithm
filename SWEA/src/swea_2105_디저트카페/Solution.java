package swea_2105_디저트카페;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] cafe;
	static int ans;

	static int[][] path;

	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	static int startR;
	static int startC;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			cafe = new int[N][N];

			// 확인용
			path = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cafe[i][j] = sc.nextInt();
				}
			}

			ans = -1;

			int d = 0;

			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {

					startR = r;
					startC = c;

					List<Integer> desserts = new ArrayList<Integer>();
					desserts.add(cafe[r][c]);
					tour(r, c, d, desserts, 1);
				}
			}

			System.out.println("#" + test_case + " " + ans);

		}

	}

	static void tour(int row, int col, int dir, List<Integer> desserts, int cnt) {

		int nr = row;
		int nc = col;
		int d = dir;

		nr += dr[d];
		nc += dc[d];

		if (nr == startR && nc == startC) {
			ans = Math.max(ans, cnt);
			System.out.println("경로 1개 찾음, ans=" + ans);
			return;
		}

		if (nr < N && nr >= 0 && nc < N && nc >= 0 && !desserts.contains(cafe[nr][nc])) {

			desserts.add(cafe[nr][nc]);

			List<Integer> tmpList = new ArrayList<Integer>();
			for (int i = 0; i < desserts.size(); i++) {
				tmpList.add(desserts.get(i));
			}

			path[nr][nc] = 1;
			cnt++;
			printArr(path);
			System.out.println(desserts);

			tour(nr, nc, d, desserts, cnt);
			desserts = tmpList;

			if (d != 3) {
				tour(nr, nc, (d + 1), desserts, cnt);
			}

		}

	}

	static void printArr(int[][] map) {
		System.out.println("---start---");

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
