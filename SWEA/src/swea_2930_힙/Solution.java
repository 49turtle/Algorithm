package swea_2930_힙;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	// 스태틱 변수로 heap 배열 선언 및 heapSize 선언
	static int[] heap;
	static int heapSize;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_2930_힙/sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 연산의 수 N
			int N = sc.nextInt();

			// heap 사이즈를 연산의 수 N + 1로 지정
			heap = new int[N + 1];
			// 스태틱 변수 heapSize 0으로 초기화
			heapSize = 0;
			
			System.out.printf("#%d ", test_case);

			for (int i = 0; i < N; i++) {
				// 삽입 연산
				if (sc.nextInt() == 1) {
					int insertNum = sc.nextInt();
					heapPush(insertNum);
				}
				// 삭제 연산
				else {
					System.out.print(heapPop() + " ");
				}
			}
			// 줄 바꿈
			System.out.println();

		}

		sc.close();
	}

	// swap 메소드 구현
	// 파라미터로 heap의 인덱스 a, b를 받아 heap 배열의 원소를 swap
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	// 힙 삽입 연산 구현
	// 파라미터로 삽입하고자 하는 정수형 데이터를 입력
	static void heapPush(int data) {
		// heapSize를 증가시킨 후 해당 자리에 data를 삽입
		heap[++heapSize] = data;

		// 삽입한 노드의 번호를 ch에 저장
		int ch = heapSize;
		int p = ch / 2;

		// 루트 노드까지만 반복, 자식 노드와 부모 노드가 바뀌어야 한다면 while문 반복 
		while (p != 0 && heap[ch] > heap[p]) {
			// 스왑하기
			swap(ch, p);
			ch = p;
			p = ch / 2;
		}
	}

	static int heapPop() {

		// 힙이 비었다면 -1을 리턴
		if (heapSize == 0) {
			return -1;
		}

		// 루트 노드의 값을 popItem에 저장
		int popItem = heap[1];

		// 루트 노드와 마지막 노드를 swap
		swap(1, heapSize);
		// swap 이후에 마지막 노드를 삭제
		heap[heapSize--] = 0;

		int p = 1;
		int ch = 2 * p;

		while (ch <= heapSize) {
			// 우측 자식이 존재하고, 우측 자식이 더 큰 경우 인덱스를 갱신
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}

			// 자식 노드가 heapSize보다 커졌거나
			// 부모 노드의 값이 자식 노드의 값과 같거나 크다면 while문 탈출
			if (ch > heapSize || heap[p] >= heap[ch]) {
				break;
			}

			// 자식 노드와 교환
			swap(p, ch);

			// 현재 노드의 위치를 갱신
			p = ch;
			ch = 2 * p;
		}

		return popItem;

	}

}
