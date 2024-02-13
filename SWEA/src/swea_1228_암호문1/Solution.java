package swea_1228_암호문1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1228_암호문1/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			SinglyLinkedList codeList = new SinglyLinkedList();

			for (int n = 0; n < N; n++) {
				codeList.addLast(sc.nextInt());
			}

			int commandNum = sc.nextInt();

			for (int c = 0; c < commandNum; c++) {
				char command = sc.next().charAt(0);
				int x = sc.nextInt();
				int y = sc.nextInt();

				for (int i = 0; i < y; i++) {
					codeList.add(x + i, sc.nextInt());
				}

			}
			
			
			// 테스트 케이스 출력
			System.out.printf("#%d ", test_case);

			// 링크드리스트의 앞 10개만 출력하기 위해 curr 노드 head로 초기화
			Node curr = codeList.head;
			for (int i = 0; i < 10; i++) {
				System.out.print(curr.link.data + " ");
				curr = curr.link;
			}
			// 줄바꿈
			System.out.println();

		}

		sc.close();

	}

}

class Node {
	int data;
	Node link;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {

	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	void addLast(int data) {

		Node newNode = new Node(data);

		Node curr = head;

		while (curr.link != null) {
			curr = curr.link;
		}

		curr.link = newNode;

		size++;

	}

	void add(int idx, int data) {

		if (idx < 0 || idx > size) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}

		Node newNode = new Node(data);

		newNode.link = curr.link;
		curr.link = newNode;

		size++;

	}

}