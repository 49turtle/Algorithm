package swea_7465_창용마을무리의개수;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 정점의 개수(번호 1부터 시작)
			int M = sc.nextInt(); // 간선의 개수

			p = new int[N + 1];
			
			// 초기화(Make-Set)
			for (int i = 1; i < N + 1; i++) {
				p[i] = i;
			}

			// 간선의 개수만큼 입력받기
			for (int i = 0; i < M; i++) {
				// 시작 정점과 끝 정점을 입력받기
				int st = sc.nextInt();
				int ed = sc.nextInt();

				// 둘을 union해준다.
				union(st, ed);
			}

			// 출력할 정답 초기화
			int ans = 0;

			// p 배열을 순회하며 본인이 루트 노드라면 ans를 1씩 증가
			for (int i = 0; i < p.length; i++) {
				if (i == p[i]) {
					ans++;
				}
			}

			System.out.println("#" + test_case + " " + (ans - 1));

		}

	}

	static int findSet(int x) {
		// By path compression
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];

	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
