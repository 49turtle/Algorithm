package swea_2117_홈방범서비스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_dfs_try {

	static int N;
	static int M;

	static int[][] map;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int house;
	static int ans;
	
	static boolean[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			M = sc.nextInt();

			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			ans = -1;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// depth 어디까지??
					for (int k = 0; k <= N + 1; k++) {
//						house = 0;
//						visited = new boolean[N][N];
						int[][] copyMap = mapCopy(map);
						bfs(copyMap, r, c, k);
//						dfs(copyMap, r, c, k, 0);
					}

				}
			}

			System.out.println("#" + test_case + " " + ans);

		}

	}

	
	static void dfs(int[][] map, int row, int col, int k, int depth) {
		
		int r = row;
		int c = col;
		
		visited[r][c] = true;
		if (map[r][c] == 1) {
			house++;
		}
		
		compareCost(depth);
		
		for (int d=0; d<4; d++) {
			
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr >= 0 && nr < N && nc >=0 && nc < N && !visited[nr][nc] && k > depth) {
				visited[nr][nc] = true;
				dfs(map, nr, nc, k, ++depth);
				visited[nr][nc] = false;
			}
		}
		
	}
	
	
	
	
	
	static void bfs(int[][] map, int row, int col, int k) {

		house = 0;

		Queue<Integer> queue = new LinkedList<Integer>();

		boolean[][] visited = new boolean[N][N];

		int depth = 1;

		int num = row * N + col;

		queue.add(num);

		visited[row][col] = true;

		if (map[row][col] == 1) {
			house++;
			if (1 <= M) {
				ans = Math.max(ans, house);
			}
		}

		while (!queue.isEmpty()) {

			if (depth == k) {
				break;
			}

			int size = queue.size();

			for (int sz = 0; sz < size; sz++) {

				int n = queue.poll();

				int r = n / N;
				int c = n % N;

				for (int d = 0; d < 4; d++) {

					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
						queue.add(nr * N + nc);

						visited[nr][nc] = true;

						if (map[nr][nc] == 1) {
							house++;
						}

					}

				}

			}

			depth++;
			compareCost(depth);

		}

	}

	static void compareCost(int depth) {

		int cost = 0;

		for (int k = 0; k < depth; k++) {
			cost += 2 * k + 1;
		}
		for (int k = 0; k < depth - 1; k++) {
			cost += 2 * k + 1;
		}
		if (cost <= M * house) {
			ans = Math.max(ans, house);
		}

	}

	static int[][] mapCopy(int[][] map) {

		int[][] copyMap = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				copyMap[r][c] = map[r][c];
			}
		}
		return copyMap;
	}

	static void printMap(int[][] map) {
		System.out.println("---start---");
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
