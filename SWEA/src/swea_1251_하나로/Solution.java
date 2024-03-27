package swea_1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] cx;
	static int[] cy;

	static double E;

	static int[] p;

	// 간선 클래스 구현
	static class Edge implements Comparable<Edge> {

		int A; // 시작노드 A
		int B; // 끝노드 B
		double W; // 가중치 W

		public Edge(int a, int b, double w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		// 정렬을 위한 비교 연산 정의
		// 가중치의 오름차순
		@Override
		public int compareTo(Edge e) {
			if (this.W - e.W >= 0) {
				return 1;
			}
			return -1;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 노드(섬)의 개수 입력받기
			int N = sc.nextInt();

			cx = new int[N]; // 각 섬의 x좌표를 담을 배열
			cy = new int[N]; // 각 섬의 y좌표를 담을 배열

			for (int i = 0; i < N; i++) {
				cx[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				cy[i] = sc.nextInt();
			}

			// 환경 부담 세율 E: 0.0 ~ 1.0
			// double 형으로
			E = sc.nextDouble();

			// 완전 그래프이므로 간선의 개수는 nC2
			Edge[] edges = new Edge[N * (N - 1) / 2];

			// 간선에 정보를 담기 위한 인덱스 설정
			int idx = 0;

			// i번 섬과 j번 섬의 거리를 계산해 간선을 생성하고, 배열에 삽입
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i > j) { // i가 j보다 클때만 값을 채워줌(lower triangular matrix)
						edges[idx++] = new Edge(i, j, getCost(i, j));
					}
				}
			}

			// override한 compareTo로 가중치를 기준으로 edges 정렬 수행
			Arrays.sort(edges);

			// 초기 포인터 생성 및 초기화
			p = new int[N];
			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}

			// 출력할 정답 초기화
			double answer = 0;
			// 간선의 개수를 1개씩 늘리면서 while문 반복할 것
			int cnt = 0;

			// 전체 간선의 개수가 섬의 개수보다 1 작을 때까지(spanning tree)
			while (cnt <= N - 1) {
				cnt++;
				// edges를 순회하며 p[A], p[B]를 갱신
				for (int i = 0; i < edges.length; i++) {
					int pA = findset(edges[i].A);
					int pB = findset(edges[i].B);

					// 만약 pA와 pB가 같지 않다면(A와 B를 연결해도 사이클이 생성되지 않는다면)
					if (pA != pB) {
						// 연결하고, 계산한 가중치를 answer에 더함
						union(pA, pB);
						answer += edges[i].W;
					}

				}

			}

			// 마지막 answer는 반올림해 출력
			System.out.println("#" + test_case + " " + Math.round(answer));

		}

	}

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findset(int x) {
		// path compression
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}

	static double getCost(int i, int j) {

		double L = Math.pow((cx[i] - cx[j]), 2) + Math.pow((cy[i] - cy[j]), 2);

		return L * E;
	}

}
