package swea_1215_하나로;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[] cx;
	static int[] cy;
	static double E;
	static ArrayList<Node>[] adjList;

	static double[] dist;
	static boolean[] visited;
	static double ans;

	static class Node {
		int v;
		double cost;

		public Node(int v, double cost) {
			this.v = v;
			this.cost = cost;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();

			cx = new int[N];
			cy = new int[N];

			for (int i = 0; i < N; i++) {
				cx[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				cy[i] = sc.nextInt();
			}

			E = sc.nextDouble();

			adjList = new ArrayList[N];

			// 각 섬마다의 인접 리스트를 생성
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
				// 인접 리스트에 자기 자신을 제외한 다른 섬들의 정보(Node)를 add
				for (int j = 0; j < N; j++) {
					if (i != j) {
						adjList[i].add(new Node(j, calcCost(i, j)));
					}
				}
			}

			// 프림 알고리즘
			prim(0);

			System.out.println("#" + test_case + " " + Math.round(E * ans));
		}

	}

	static void prim(int st) {

		ans = 0;
		dist = new double[N];
		visited = new boolean[N];

		// 초기 거리 비용 큰 값으로 초기화
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Double.MAX_VALUE;
		}

		// start 노드까지(자기 자신)의 거리는 0으로
		dist[st] = 0;

		// 정점의 수만큼 반복
		for (int i = 0; i < N; i++) {

			double min = Double.MAX_VALUE;
			int idx = -1;

			// 방문하지 않은 섬들 중 거리 비용이 제일 작은 섬을 선택해
			// min에 비용을 저장, idx에 섬 번호를 저장
			for (int j = 0; j < N; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}

			// 해당 섬을 방문 체크
			visited[idx] = true;

			// 해당 섬과 연결된 인접리스트를 탐색
			for (Node node : adjList[idx]) {
				// 거리를 갱신
				if (!visited[node.v] && dist[node.v] > node.cost) {
					dist[node.v] = node.cost;
				}
			}
		}

		// 모든 섬을 돌고 나서 갱신된 거리 비용의 합을 계산
		for (int i = 0; i < dist.length; i++) {
			ans += dist[i];
		}

	}

	static double calcCost(int st, int ed) {
		double cost = 0;
		cost = Math.pow(cx[st] - cx[ed], 2) + Math.pow(cy[st] - cy[ed], 2);
		return cost;
	}

}
