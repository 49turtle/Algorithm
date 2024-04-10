package boj_14888_연산자끼워넣기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;
	static int[] oper;

	static int[] operArr;

	static boolean[] visited;

	static int[] permArr;

	static long max;
	static long min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		oper = new int[4];

		operArr = new int[N - 1];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int idx = 0;

		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
			if (oper[i] > 0) {
				for (int j = 0; j < oper[i]; j++) {
					operArr[idx++] = i;
				}
			}
		}

		visited = new boolean[N - 1];
		permArr = new int[N - 1];

		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;

		perm(0);

		System.out.println(max);
		System.out.println(min);

	}

	static int calcArr() {

		int result = arr[0];

		for (int i = 0; i < N - 1; i++) {

			// 덧셈
			if (permArr[i] == 0) {
				result += arr[i + 1];
			}

			// 뺄셈
			else if (permArr[i] == 1) {
				result -= arr[i + 1];
			}

			// 곱셈
			else if (permArr[i] == 2) {
				result *= arr[i + 1];
			}

			// 나눗셈
			else {
				if (result < 0) {
					int temp = Math.abs(result);
					temp /= arr[i + 1];
					result = temp * (-1);
				} else {
					result /= arr[i + 1];
				}
			}

		}

		return result;

	}

	static void perm(int idx) {
		if (idx == N - 1) {

			int result = calcArr();

			max = Math.max(max, result);
			min = Math.min(min, result);

			return;
		}

		for (int i = 0; i < N - 1; i++) {

			if (visited[i]) {
				continue;
			}
			permArr[idx] = operArr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
