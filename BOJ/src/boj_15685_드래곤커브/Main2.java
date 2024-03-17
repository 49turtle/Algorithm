package boj_15685_드래곤커브;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	static List<Integer> list;
	static boolean[][] map;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		map = new boolean[101][101];

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			int c = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();

			list = new ArrayList<Integer>();
			calcDirection(d, g);

			doMove(r, c);

		}

		System.out.println(calcAnswer());

		sc.close();
	}

	static void calcDirection(int dir, int gen) {

		list.add(dir);

		while (gen > 0) {
			gen--;
			int s = list.size();
			for (int i = s - 1; i >= 0; i--) {
				int d = list.get(i);
				d = (d + 1) % 4;
				list.add(d);

			}

		}

	}

	static void doMove(int r, int c) {

		int nr = r;
		int nc = c;

		map[nr][nc] = true;

		for (int d = 0; d < list.size(); d++) {
			nr += dr[list.get(d)];
			nc += dc[list.get(d)];

			map[nr][nc] = true;

		}

	}

	static int calcAnswer() {
		int answer = 0;
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[i].length - 1; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					answer++;
				}
			}
		}

		return answer;
	}

}
