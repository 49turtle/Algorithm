package swea_7102_준홍이의카드놀이;

import java.util.Scanner;

class Node {

	// Node는 int형의 data값을 지니고
	int data;
	// 각 부모 노드는 lefts와 right 노드들을 지님
	// lefts는 Node의 배열로 선언하여 왼쪽 자식 노드들을 배열로 묶어놓음
	Node[] lefts;
	Node right;

	// 기본 생성자
	Node() {
	}

	// 파라미터 생성자
	Node(int data) {
		this.data = data;
	}
}

public class Solution_tree {

	// n+m 값이 각각 몇 번 등장하는지 카운트하는 카운팅 배열 static으로 선언
	static int[] sumList;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// N, M 값 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 두 수의 합의 최댓값은 N+M을 넘지 않으므로
			// 인덱스 값이 두 수의 합의 값과 일치하도록 N+M+1 길이를 갖는 배열을 생성
			sumList = new int[N + M + 1];

			// root 노드 선언 및 1로 초기화
			Node root = new Node(1);
			// 현재 노드를 뜻하는 curr에 root로 초기화
			Node curr = root;

			// 1부터 N까지 증가하며 각 노드의 자식을 지정해줌
			for (int i = 1; i < N + 1; i++) {
				// 우선, 현재 노드(curr)의 왼쪽 자식들에 담길 노드는 1~M의 값들이므로 길이 M의 배열 생성
				curr.lefts = new Node[M];
				for (int j = 0; j < M; j++) {
					// lefts 배열 안의 노드들은 1부터 M까지의 값들로 저장
					curr.lefts[j] = new Node(j + 1);
				}
				// 이후 오른쪽 자식 노드는 1개만 지정(1~N까지 커질 것)
				curr.right = new Node(i + 1);
				// 현재 노드를 현재 노드의 오른쪽 자식 노드로 이동하고 for문을 반복
				curr = curr.right;

			}

			// 새롭게 정의한 preorderSum 메소드 수행
			preorderSum(root, M);

			// 두 수를 더한 값 중에 가장 많이 등장하는 수를 찾기 위한 max값 선언
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < sumList.length; i++) {
				if (max < sumList[i]) {
					max = sumList[i];
				}
			}

			// 테스트 케이스 출력
			System.out.printf("#%d ", test_case);
			// 카운팅 배열을 활용해 최빈값들을 출력
			for (int i = 0; i < sumList.length; i++) {
				if (max == sumList[i]) {
					System.out.print(i + " ");
				}
			}
			// 줄바꿈
			System.out.println();

		}

		sc.close();

	}

	// VLR 순회에서 아이디어를 착안해 새로 구성한 preorderSum 메소드
	// 파라미터로 현재 노드(node), 왼쪽 자식들(lefts)의 개수(M)을 입력받음
	static void preorderSum(Node node, int M) {

		// n과 m 초기화
		int n = -1;
		int m = -1;
		// 현재 노드의 자식이 없을 때까지(lefts가 null일 때까지) 재귀함수 실행
		if (node.lefts != null) {
			// n은 현재 노드에 저장된 int형의 데이터
			n = node.data;
			for (int i = 0; i < M; i++) {
				// 현재 노드의 왼쪽 자식들을 하나씩 꺼내와 데이터를 m에 저장
				m = node.lefts[i].data;
				// n과 m을 더한 수가 카운팅 배열에 더해지도록 static 변수 sumList를 사용
				sumList[n + m]++;
			}
			// 오른쪽 노드에 대해서 재귀함수 반복
			preorderSum(node.right, M);
		}
		return;

	}

}
