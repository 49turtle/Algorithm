package swea_8931_제로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	// stack을 static으로 선언
	static int[] stack;
	// stack의 top을 -1로 초기화하고, static으로 선언
	static int top=-1;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_8931_제로/sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 각 테스트 케이스에서 입력받을 정수의 개수 K개
			int K = sc.nextInt();
			
			// K개만큼의 size를 가진 stack을 초기화
			stack = new int[K];
			
			// K개의 숫자를 반복하며 입력 받음
			for (int k=0; k<K; k++) {
				int num = sc.nextInt();
				// 만약 0보다 크다면 stack에 push
				if (num > 0) {
					push(num);
				}
				// 만약 0이라면 stack에서 pop
				else if (num == 0) {
					pop();
				}
			}
			
			// stack에서 top까지의 원소를 더해서 답을 출력
			int sum = 0;
			for (int i=0; i<=top; i++) {
				sum += stack[i];
			}
			
			System.out.printf("#%d %d\n", test_case, sum);
			
			// static 변수인 top을 다시 -1로 갱신
			top = -1;

		}

	}
	
	
	
	
	// 아래는 stack의 메소드를 구현
	public static boolean isEmpty() {
		return top==-1;
	}
	
	public static boolean isFull() {
		return top==stack.length-1;
	}
	
	public static int pop() {
		if (isEmpty()) {
			System.out.println("error: 스택이 비어있습니다.");
			return Integer.MIN_VALUE;
		}
		else {
			return stack[top--];
		}
	}
	
	public static void push(int data) {
		if (isFull()) {
			System.out.println("error: 스택이 꽉 차있습니다.");
		}
		else {
			stack[++top] = data;
		}
	}
	
	
}



