package boj_1941_소문난칠공주;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] seats;

	static int[] sel;

	static List<int[]> selList;

	static int sevenCnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		seats = new int[5][5];

		for (int i = 0; i < 5; i++) {
			String str = sc.nextLine();

			for (int j = 0; j < 5; j++) {
				seats[i][j] = str.charAt(j);
			}
		}

		sel = new int[7];
		selList = new ArrayList<int[]>();

		comb(0, 0);

		int answer = 0;

		for (int i = 0; i < selList.size(); i++) {
			if (isConnected(selList.get(i))) {

				answer++;
			}
		}

		System.out.println(answer);

	}

	static void comb(int idx, int sidx) {

		if (sidx == 7) {
			int[] tmp = new int[7];
			for (int i = 0; i < 7; i++) {
				tmp[i] = sel[i];
			}
			selList.add(tmp);
			return;
		}

		if (idx == 25) {
			return;
		}

		sel[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);

	}

	static boolean isConnected(int[] selected) {

		int[][] map = new int[5][5];

		for (int i = 0; i < 7; i++) {
			int num = selected[i];
			int row = num / 5;
			int col = num % 5;

			map[row][col] = 1;
		}

		int nr = selected[0] / 5;
		int nc = selected[0] % 5;

		dfs(map, nr, nc);

		return checkMap(map, seats, selected);

	}

	static void dfs(int[][] map, int r, int c) {

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		map[r][c] = 0;

		for (int d = 0; d < 4; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs(map, nr, nc);
			}

		}

	}

	static boolean checkMap(int[][] map, int[][] seats, int[] selected) {

		boolean flag = true;
		int cntS = 0;

		for (int i = 0; i < 7; i++) {
			int num = selected[i];

			int row = num / 5;
			int col = num % 5;

			if (map[row][col] != 0) {
				flag = false;
			}
			if (seats[row][col] == 83) {
				cntS++;
			}

		}

		if (flag && cntS >= 4) {
			return true;
		}

		return false;

	}
}
