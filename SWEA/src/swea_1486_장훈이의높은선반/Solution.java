package swea_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {

	static int answer;
	static int N;
	static int B;
	static int[] heights;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			B = sc.nextInt();

			heights = new int[N];

			answer = 987654321;

			for (int i = 0; i < N; i++) {
				heights[i] = sc.nextInt();
			}

			comb(0, 0);

			System.out.println("#" + test_case + " " + answer);

		}

	}

	static void comb(int sum, int idx) {

		if (sum >= B) {
			answer = Math.min(answer, sum - B);
			return;
		}

		if (idx >= N) {
			return;
		}

		comb(sum, idx + 1);
		comb(sum + heights[idx], idx + 1);

	}

}
