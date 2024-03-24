package boj_15657_N과M_8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;

	static int[] arr;
	static int[] result;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);
		System.out.println(sb);

	}

	static void perm(int idx) {

		if (idx == M) {

			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {

			result[idx] = arr[i];
			perm(idx + 1);

		}

	}

}