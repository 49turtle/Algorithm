package boj_15663_N과M_9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int M;
	static int N;

	static int[] arr;
	static int[] result;

	static boolean[] visited;

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

		visited = new boolean[N];

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

			if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
				continue;
			}

			if (visited[i]) {
				continue;
			}

			result[idx] = arr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}

	}

}