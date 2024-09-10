package boj_13565_침투;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();

		int N = sc.nextInt();

		int[][] map = new int[M][N];

		for (int r = 0; r < M; r++) {
			String str = sc.next();

			for (int c = 0; c < N; c++) {
				int num = str.charAt(c);
				if (num == '0') {
					map[r][c] = 0;
				} else {
					map[r][c] = 1;
				}
			}
		}
//		printMap(map);

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			if (map[0][i] == 0) {
				int num = 0 + i;
				queue.add(num);
			}
		}

		while (!queue.isEmpty()) {

			int num = queue.poll();

			int nr = num / N;
			int nc = num % N;

			map[nr][nc] = 2;

			for (int d = 0; d < 4; d++) {

				int r = nr + dr[d];
				int c = nc + dc[d];

				if (r >= 0 && r < M && c >= 0 && c < N && map[r][c] == 0) {
					if (r == M - 1) {
//						printMap(map);
						System.out.println("YES");
						return;
					}
					map[r][c] = 2;
					num = r * N + c;
					queue.add(num);
				}
			}

		}

//		printMap(map);

		System.out.println("NO");

	}

	static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println();
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
		}
	}

}
