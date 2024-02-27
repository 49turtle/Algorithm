package swea_2817_부분수열의합;

import java.util.Scanner;

public class Solution {

	// getSum에 쓰일 변수들 static으로 선언
	static int[] arr;
	static int answer;
	static int target;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int K = sc.nextInt();

			// N개의 숫자 배열 arr 갱신 및 입력받기
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// K를 static 변수 target으로 옮겨줘 갱신
			target = K;

			// answer 0으로 갱신
			answer = 0;

			// getSum() 메소드를 사용해 정답을 출력
			getSum(0, 0);
			System.out.printf("#%d %d\n", test_case, answer);

		}

		sc.close();
	}

	static void getSum(int idx, int sum) {
		// 더 이상 사용할 숫자가 없을 때 return.
		if (idx >= arr.length) {
			return;
		}
		// 만약 target과 값이 똑같아지는 순간 answer에 1을 더함
		if (sum + arr[idx] == target) {
			answer++;
		}
		// target보다 작다면 sum에 더하고, getSum을 반복
		if (sum + arr[idx] < target) {
			getSum(idx + 1, sum + arr[idx]);
		}
		// 현재 숫자를 더하지 않고, 다음 숫자를 더할지 말지 판단.
		getSum(idx + 1, sum);
	}

}
