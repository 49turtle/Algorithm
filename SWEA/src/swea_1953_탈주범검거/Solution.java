package swea_1953_탈주범검거;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N; // 지도의 세로 크기
	static int M; // 지도의 가로 크기
	static int R; // 맨홀 뚜껑 세로 위치
	static int C; // 맨홀 뚜껑 가로 위치
	static int L; // 탈출 후 소요된 시간

	static int[][] map; // 지하 터널 지도

	static boolean[][] visited;

	// 상 -> 우 -> 하 -> 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 0: 상, 1: 우, 2: 하, 3: 좌
	static int[][] tunnel = new int[8][4];

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		tunnel[1][0] = 1;
		tunnel[1][1] = 1;
		tunnel[1][2] = 1;
		tunnel[1][3] = 1;

		tunnel[2][0] = 1;
		tunnel[2][2] = 1;

		tunnel[3][1] = 1;
		tunnel[3][3] = 1;

		tunnel[4][0] = 1;
		tunnel[4][1] = 1;

		tunnel[5][1] = 1;
		tunnel[5][2] = 1;

		tunnel[6][2] = 1;
		tunnel[6][3] = 1;

		tunnel[7][0] = 1;
		tunnel[7][3] = 1;

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();

			map = new int[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			ans = 0;

			bfs(R, C, L);

			System.out.println("#" + test_case + " " + ans);

		}

	}

	static void bfs(int row, int col, int L) {

		Queue<Integer> queue = new LinkedList<Integer>();

		visited = new boolean[N][M];

		int num = row * M + col;

		queue.add(num);
		visited[row][col] = true;
		ans++;

		int depth = 1;

		while (!queue.isEmpty()) {

			if (depth == L) {
				break;
			}

			int size = queue.size();

			for (int sz = 0; sz < size; sz++) {

				int n = queue.poll();

				int r = n / M;
				int c = n % M;

				// 이동 전의 구조물 타입
				int st = map[r][c];

				for (int d = 0; d < 4; d++) {

					// 상우하좌
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						// 이동 후의 구조물 타입
						int ed = map[nr][nc];

						// 위로 터널이 이어져있다면
						if (d == 0 && tunnel[st][0] == 1 && tunnel[ed][2] == 1) {
							ans++;
							queue.add(nr * M + nc);
							visited[nr][nc] = true;
						}

						// 오른쪽으로 터널이 이어져있다면
						else if (d == 1 && tunnel[st][1] == 1 && tunnel[ed][3] == 1) {
							ans++;
							queue.add(nr * M + nc);
							visited[nr][nc] = true;
						}

						// 아래쪽으로 터널이 이어져있다면
						else if (d == 2 && tunnel[st][2] == 1 && tunnel[ed][0] == 1) {
							ans++;
							queue.add(nr * M + nc);
							visited[nr][nc] = true;
						}

						// 왼쪽으로 터널이 이어져있다면
						else if (d == 3 && tunnel[st][3] == 1 && tunnel[ed][1] == 1) {
							ans++;
							queue.add(nr * M + nc);
							visited[nr][nc] = true;
						}

					}
				}

			}

			depth++;

		}

	}

}
