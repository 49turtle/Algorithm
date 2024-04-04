package swea_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[] answer = new int[8];

			for (int i = 0; i < 8; i++) {
				// 최대 금액부터 현재 목표 금액에 채울 수 있을 만큼 넣기
				while (money[i] <= N) {
					answer[i]++;
					// 넣었다면 목표 금액을 갱신
					N -= money[i];
				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();

		}

	}

}
