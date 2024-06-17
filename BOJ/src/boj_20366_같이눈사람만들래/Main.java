package boj_20366_같이눈사람만들래;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();



		int[] snowArr = new int[N];

		for (int i = 0; i < N; i++) {

			snowArr[i] = sc.nextInt();

		}
		
		Arrays.sort(snowArr);

		int answer = Integer.MAX_VALUE;

		for (int l1 = 0; l1 < N - 3; l1++) {

			for (int r1 = N - 1; r1 > l1 + 2; r1--) {

				for (int l2 = l1 + 1; l2 < r1 - 1; l2++) {

					for (int r2 = r1 - 1; r2 > l2; r2--) {

						// System.out.println("l1=" + l1 + ", r1=" + r1 + ", l2=" + l2 + ", r2=" + r2);
						// System.out.println("l1=" + snowArr[l1] + ", r1=" + snowArr[r1] + ", l2=" + snowArr[l2] + ", r2=" + snowArr[r2]);
						// System.out.println("----");

						int height1 = snowArr[l1] + snowArr[r1];
						int height2 = snowArr[l2] + snowArr[r2];

						answer = Math.min(Math.abs(height1 - height2), answer);

						if (answer == 0) {
							System.out.println(0);
							return;
						}

					}

				}

			}

		}

		System.out.println(answer);

	}

}
