package swea_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	
	// 자료구조 Queue를 사용하기 위한 static 변수 선언
	static String[] queue;
	static int rear;
	static int front;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 전체 테스트 케이스 수 T
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// N개의 카드
			int N = sc.nextInt();
			
			// 각 테스트 케이스마다 static 변수를 초기화, queue의 길이는 N만큼으로 초기화
			rear = -1;
			front = -1;
			queue = new String[N];


			// String형 배열로 card의 정보를 입력받음
			String[] cardArr = new String[N];
			for (int n = 0; n < N; n++) {
				cardArr[n] = sc.next();
			}
			
			// 사용자 정의 메소드 shuffleCards로 퍼펙트셔플 순서대로 queue에 삽입
			shuffleCards(cardArr);
			
			// 결과를 출력
			System.out.printf("#%d ", test_case);
			// 큐가 빌 때까지 deQueue를 실행하며 출력
			while (!isEmpty()) {
				System.out.print(deQueue() + " ");
			}
			// 줄바꿈
			System.out.println();
			
		}

		sc.close();

	}
	
	
	// shuffleCards라는 메소드를 정의
	// String형의 배열을 받아 해당 배열의 원소들을 퍼펙트 셔플하고자 함
	public static void shuffleCards(String[] cardArr) {
		// cardArr의 길이를 N으로 저장
		int N = cardArr.length;
		// 홀수, 짝수에 따라(나머지 연산) 퍼펙트셔플을 진행
		for (int i=0; i<=N/2-1; i++) {
			enQueue(cardArr[i]);
			enQueue(cardArr[i+N/2+N%2]);
		}
		// 홀수인 경우 마지막 한 장을 추가로 enQueue
		if (N % 2 == 1) {
			enQueue(cardArr[N/2]);
		}
		
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	
	public static boolean isFull() {
		return rear == queue.length-1;
	}
	

	public static void enQueue(String card) {
		queue[++rear] = card;
	}
	
	public static String deQueue() {
		if (isEmpty()) {
			System.out.println("더 이상 제거할 원소가 없습니다.");
			return "";
			}
		return queue[++front];
	}
	
	
	
}