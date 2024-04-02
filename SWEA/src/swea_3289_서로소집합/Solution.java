package swea_3289_서로소집합;

import java.util.Scanner;

public class Solution {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			p = new int[n + 1];

			for (int i = 1; i < p.length; i++) {
				p[i] = i;
			}
			System.out.print("#" + test_case + " ");

			for (int i = 0; i < m; i++) {

				int command = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();

				int px = findSet(x);
				int py = findSet(y);
				if (command == 0) {
					union(px, py);
				} else {
					if (px == py) {
						System.out.print("1");
					} else {
						System.out.print("0");
					}
				}

			}
		}
		System.out.println();

	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {

		p[y] = x;

	}

}
