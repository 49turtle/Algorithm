package boj_4963_섬의개수;

import java.util.Scanner;

public class Main2 {

	static int w;
	static int h;
	static int[][] map;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h + 2][w + 2];
			visited = new boolean[h+2][w+2];

			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < w + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int answer = 0;

			for (int r = 1; r < h + 1; r++) {
				for (int c = 1; c < w + 1; c++) {

					if (map[r][c] == 1 && !visited[r][c]) {
						findIsland(r, c);
						answer++;
					}

				}
			}
			System.out.println(answer);
		}

	}

	static void findIsland(int r, int c) {

		map[r][c] = 0;

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (map[nr][nc] == 1 && !visited[nr][nc]) {
				findIsland(nr, nc);
			}

		}
		

	}


}
