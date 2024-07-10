package boj_2533_사회망서비스;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 노드의 수 입력

		int[] pArr = new int[N + 1]; // 각 노드의 부모 노드를 저장할 배열
		boolean[] isLeaf = new boolean[N + 1]; // 리프 노드 여부를 저장할 배열

		for (int i = 1; i < N + 1; i++) {
			isLeaf[i] = true; // 우선 모든 노드를 리프 노드로 초기화
		}

		for (int i = 1; i < N; i++) {
			int p = sc.nextInt(); // 부모 노드
			int ch = sc.nextInt(); // 자식 노드
			pArr[ch] = p;

			isLeaf[p] = false; // 부모 노드는 리프 노드가 아니므로 false로 설정
		}

		List<Integer> pLeafList = new ArrayList<>(); // 부모 리프 노드 리스트

		boolean[] visited = new boolean[N + 1]; // 방문 여부를 체크하는 배열

		visited[0] = true; // 0번 노드는 사용하지 않으므로 true로 설정

		int answer = 0; // 얼리 어답터 수

		for (int i = 1; i < N + 1; i++) {
			if (isLeaf[i] && !pLeafList.contains(pArr[i])) { // 현재 노드가 리프 노드이고, 부모 노드가 리스트에 없으면
				pLeafList.add(pArr[i]); // 리프의 부모를 리스트에 추가
				visited[pArr[i]] = true; // 부모를 방문 처리
				answer++; // 얼리 어답터 수 증가

				int curr = pArr[pArr[i]]; // 리프의 부모의 부모 노드

				while (curr != 0) { // 루트 노드에 도달할 때까지 반복
					if (visited[curr]) {
						break; // 현재 노드를 이미 방문했으면 종료
					}
					if (!visited[pArr[curr]]) { // 현재 노드의 부모 노드를 방문하지 않았으면
						visited[pArr[curr]] = true; // 부모 노드를 방문 처리
						answer++; // 얼리 어답터 수 증가
					}
					curr = pArr[curr]; // 현재 노드를 부모 노드로 갱신
				}
			}
		}

		System.out.println(answer); // 결과 출력
	}
}
