package swea_1238_Contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력 받을 데이터의 개수 N
			int N = sc.nextInt();
			// 시작 노드 번호 st
			int st = sc.nextInt();

			// 번호가 최대 100까지이므로 101개의 길이를 가진 인접리스트 배열 생성
			List<Integer>[] adjList = new ArrayList[101];

			// N/2만큼 두 개씩(from-to)을 입력받음, 결국 2*N개 입력받는 것
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				// from 번호의 인접리스트가 아직 생성되지 않았다면 생성하고
				if (adjList[from] == null) {
					adjList[from] = new ArrayList<>();
				}
				// adjList에 인접한 단방향 연결을 생성
				adjList[from].add(to);
			}

			// bfs를 위한 queue를 생성
			Queue<Integer> queue = new LinkedList<Integer>();

			// 방문했는가?를 표시할 boolean 배열 visited
			boolean[] visited = new boolean[101];

			// 첫 시작점 더하고 시작
			queue.add(st);
			// 시작점 방문 체크
			visited[st] = true;

			// 최종 마지막 레벨에 도달한 노드의 번호들을 담을 list 초기화
			List<Integer> resultList = new ArrayList<Integer>();

			// bfs
			while (!queue.isEmpty()) {

				// 큐의 사이즈를 저장해놓고
				int size = queue.size();
				// 각 레벨마다의 노드들을 저장할 임시 리스트 생성
				List<Integer> tempList = new ArrayList<>();

				// 사이즈만큼 for문 반복
				for (int i = 0; i < size; i++) {
					// size만큼 반복하며 시작점(from)을 큐에서 꺼내온다.
					int from = queue.poll();

					// 각 from에 대한 인접리스트가 null이 아닌 경우에 아래를 실행
					if (adjList[from] != null) {
						// 인접리스트에서 to를 모두 꺼내오고
						for (int to : adjList[from]) {
							// 각 to가 아직 방문하지 않은 노드라면 큐에 더하고, 방문체크
							if (!visited[to]) {
								queue.add(to);
								visited[to] = true;
								// 그러한 to들을 현재 레벨의 리스트에 더해줌
								tempList.add(to);
							}
						}
					}

				}

				// tempList가 안 비어있을 때 각 레벨마다의 tempList를 resultList에 옮겨 담는다.
				if (!tempList.isEmpty()) {
					resultList.clear();
					for (int i = 0; i < tempList.size(); i++) {
						resultList.add(tempList.get(i));
					}
				}

			}

			// 마지막 레벨의 노드를 담은 resultList를 돌며 최댓값을 찾음
			int maxNum = 0;
			for (int i = 0; i < resultList.size(); i++) {
				if (maxNum < resultList.get(i)) {
					maxNum = resultList.get(i);
				}
			}

			System.out.println("#" + test_case + " " + maxNum);

		}

	}

}
