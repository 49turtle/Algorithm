package swea_1218_괄호짝짓기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	static char[] stack;
	static int top = -1;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/swea_1218_괄호짝짓기/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			// 각 테스트 케이스의 길이
			int N = sc.nextInt();

			// 다음 줄을 입력받기 위한 한 줄 입력
			sc.nextLine();

			// stack 자료 구조를 구하여 사용(여는 괄호를 담을 공간)
			stack = new char[N];

			// 괄호 여러 개로 구성된 문자열을 charater형으로 쪼개 배열 형태로 저장
			char[] arr = sc.nextLine().toCharArray();

			// 괄호 유효성 여부(출력하고자 하는 정답: default는 1로 초기화)
			int answer = 1;

			// 괄호 문자열의 길이만큼 반복
			for (int i = 0; i < N; i++) {
				// 만약 여는 괄호 '(', '{', '[', '<'라면 stack에 저장
				if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[' || arr[i] == '<') {
					push(arr[i]);

					// 만약 닫는 괄호라면 stack 위에서 하나 꺼내 짝이 맞는 괄호인지 확인
					// 짝이 맞지 않는다면 유효성 여부를 0으로 바꾸고, break.
				} else {
					char bracket = pop();
					if (arr[i] == ')' && bracket != '(') {
						answer = 0;
						break;
					} else if (arr[i] == '}' && bracket != '{') {
						answer = 0;
						break;
					} else if (arr[i] == ']' && bracket != '[') {
						answer = 0;
						break;
					} else if (arr[i] == '>' && bracket != '<') {
						answer = 0;
						break;
					}

				}

			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static char pop() {
		if (isEmpty()) {
			System.out.println("stack이 비었습니다. pop이 불가합니다.");
			return '1';
		} else {
			return stack[top--];
		}

	}

	public static void push(char data) {
		if (isFull()) {
			System.out.println("stack이 꽉 찼습니다. push가 불가합니다.");
		} else {
			stack[++top] = data;
		}

	}

}