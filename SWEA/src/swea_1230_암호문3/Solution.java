package swea_1230_암호문3;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 링크드리스트를 구현하기 위한 Node 클래스 설계
class Node {

	int data;
	Node prev;
	Node next;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

// DoubleLinkedList 구현
class DoubleLinkedList {

	int size;
	Node head;
	Node tail;

	// 기본 생성자: 양방향 리스트 초기화
	// head의 next 링크는 tail로, tail의 prev 링크는 head로
	DoubleLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 삽입
	// 리스트의 마지막에 삽입
	void addLast(int data) {

		Node newNode = new Node(data);

		// tail 앞에 새로운 노드 newNode를 삽입
		newNode.next = tail;
		newNode.prev = tail.prev;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;

		// 링크드리스트 size를 1 증가
		size++;

	}

	// 리스트의 중간에 삽입
	// 삽입을 원하는 위치의 인덱스를 입력받기
	void add(int idx, int data) {

		// 링크드리스트의 인덱스 유효 범위
		if (idx < 0 || idx > size) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}

		// 입력받은 데이터로 새로운 newNode 생성
		Node newNode = new Node(data);

		// 현재 노드를 head로 초기화
		Node curr = head;

		// idx만큼 Node를 이동한다.
		// 삽입할 위치로 이동
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}

		// curr.next와 curr 사이에 newNode를 삽입
		newNode.next = curr.next;
		newNode.prev = curr;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;

		// 링크드리스트 size를 1 증가
		size++;
	}

	void remove(int idx) {

		// 링크드리스트의 인덱스 유효 범위
		if (idx < 0 || idx > size) {
			System.out.println("삭제할 수 없는 위치입니다.");
			return;
		}

		// 내가 지우고자 하는 rmNode라는 변수로 저장
		// 우선 head의 다음 노드로 초기화
		Node rmNode = head.next;
		// idx만큼 이동시켜 지우고자 하는 rmNode로 이동
		for (int i = 0; i < idx; i++) {
			rmNode = rmNode.next;
		}

		// 삭제된 노드의 전 노드와 후 노드를 연결
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;

		// 링크드리스트의 size를 1 감소
		size--;

	}

}

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

//		System.setIn(new FileInputStream("src/swea_1230_암호문3/input.txt"));

		Scanner sc = new Scanner(System.in);

		// 전체 테스트 케이스 수는 10개
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			// 암호문의 개수 N
			int N = sc.nextInt();

			// DoubleLinkedList 초기화(codeList)
			DoubleLinkedList codeList = new DoubleLinkedList();

			// addLast() 메소드로 N개의 암호문을 양방향으로 연결된 노드로 저장
			for (int n = 0; n < N; n++) {
				codeList.addLast(sc.nextInt());
			}

			// 입력받을 명령어의 개수
			int commandNum = sc.nextInt();

			// 입력받는 명령어의 개수만큼 for문 반복
			for (int c = 0; c < commandNum; c++) {
				// 입력받은 command를 char형으로 저장
				char command = sc.next().charAt(0);

				// 삽입
				if (command == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// x+i 위치에 data를 삽입
					for (int i = 0; i < y; i++) {
						codeList.add(x + i, sc.nextInt());
					}

				}

				// 삭제
				else if (command == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// (x+i) 위치에 data를 삭제
					for (int i = 0; i < y; i++) {
						codeList.remove(x + i);
					}

				}

				// 추가
				else {
					int y = sc.nextInt();
					for (int i = 0; i < y; i++) {
						codeList.addLast(sc.nextInt());
					}
				}

			}

			// 테스트 케이스 출력
			System.out.printf("#%d ", test_case);

			// 링크드리스트의 앞 10개만 출력하기 위해 curr 노드 head로 초기화
			Node curr = codeList.head;
			for (int i = 0; i < 10; i++) {
				System.out.print(curr.next.data + " ");
				curr = curr.next;
			}
			// 줄바꿈
			System.out.println();

		}

		sc.close();

	}

}
