package swea_2805_농작물수확하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_2805_농작물수확하기/input.txt"));

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// N x N의 N 입력
			int N = sc.nextInt();

			// 전체 수확한 가치
			int answer = 0;

			// 인덱스를 조정하기 위한 변수 idx
			int idx = 1;

			sc.nextLine();

			// 1 x 1인 경우
			if (N == 1) {
				answer = sc.nextInt();
			}

			else {

				// 인덱스의 증감을 결정하기 위한 변수 dir
				// 1이면 +, -1이면 -
				int dir = 1;
				for (int row = 0; row < N; row++) {

					// 중간값에 해당하는 row라면 dir을 -1로
					if (row >= N / 2) {
						dir = -1;
					}

					// String 배열로 입력받기
					String[] rowArr = sc.nextLine().split("");

					int cnt = 0;
					for (int i = 0; i < Math.abs(N / 2 - row); i++) {
						cnt++;
					}
					// 수확해야하는 곳이라면 answer에 더해줌
					for (int i = cnt; i < cnt + idx; i++) {
						answer += Integer.parseInt(rowArr[i]);
					}
					idx = idx + 2 * dir;

				}

			}
			System.out.printf("#%d %d\n", test_case, answer);

		}

		sc.close();
	}

}
