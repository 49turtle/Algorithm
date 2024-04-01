package swea_1267_작업순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int V = sc.nextInt(); // 정점의 수
			int E = sc.nextInt(); // 간선의 수

			// 인접 행렬
			int[][] adj = new int[V + 1][V + 1];
			// 각 노드의 진입 차수
			int[] degree = new int[V + 1];

			// 간선의 수만큼 반복
			for (int i = 0; i < E; i++) {
				// A -> B로 향하는 유향 그래프 표현
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A][B] = 1;
				// B로 들어오는 진입차수 1 증가
				degree[B]++;
			}

			Queue<Integer> queue = new LinkedList<>();

			// 초기 진입 차수가 0인 노드들을 queue에 삽입 
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}

			System.out.print("#" + test_case + " ");

			// queue가 빌 때까지
			while (!queue.isEmpty()) {

				// queue에서 노드를 하나 꺼내 curr로 지정
				int curr = queue.poll();

				// 꺼낸 노드를 출력
				System.out.print(curr + " ");

				for (int i = 0; i < V + 1; i++) {
					// 현재 노드와 연결되어 있는 노드들을 확인
					if (adj[curr][i] == 1) {
						// 해당 노드의 진입차수를 1 감소 
						degree[i]--;
						// 만약 감소한 진입차수가 0이라면(선행 작업을 모두 수행했다면) queue에 삽입
						if (degree[i] == 0) {
							queue.add(i);
						}
					}
				}
			}
			// 줄바꿈
			System.out.println();
		}

	}
}
