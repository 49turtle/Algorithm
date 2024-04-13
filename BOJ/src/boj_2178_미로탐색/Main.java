package boj_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		int[][] map = new int[N][M];

		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] splitLine = line.split("");
			for (int j = 0; j < M; j++) {
				if (splitLine[j].equals("1")) {
					map[i][j] = 1;
				}
			}
		}

		boolean[] visited = new boolean[N * M];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(0);
		visited[0] = true;

		int depth = 0;

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		out: while (!queue.isEmpty()) {

			depth++;
			int size = queue.size();

			for (int sz = 0; sz < size; sz++) {

				int n = queue.poll();

				int r = n / M;
				int c = n % M;

				if (r == N - 1 && c == M - 1) {
					break out;
				}

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr * M + nc]) {
						int num = nr * M + nc;
						queue.add(num);
						visited[num] = true;
					}

				}

			}

		}

		System.out.println(depth);

	}
}
