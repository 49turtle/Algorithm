package swea_1222_계산기1;

import java.util.Scanner;

public class Solution {

	static char[] stack;
	static int top = -1;

	// 후위 표기식 계산을 위한 stack(숫자를 담아야하므로 int형)
	static int[] int_stack;
	static int int_top = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 전체 테스트 케이스의 수는 10개
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			// 문자열의 전체 길이를 입력 받기
			int str_len = Integer.parseInt(sc.nextLine());

			// 후위 표기식으로 바꾸기 위한 stack 생성
			stack = new char[str_len];

			// 문자열을 입력받는다.
			String str = sc.nextLine();

			// 입력받은 문자열을 char형의 배열로 변환
			char[] charArr = str.toCharArray();

			
			// 변환할 후위 표기식을 초기화
			String postfix = "";

			// 전체 문자 배열의 길이만큼 반복 실행
			for (int i = 0; i < str_len; i++) {
				// 배열의 원소 하나를 c로 저장
				char c = charArr[i];
				

				// 만약 c가 숫자값이라면
				if (c >= '0' && c <= '9') {
					// 후위표기식에 바로 더해주고
					postfix += c;
				}

				// 만약 c가 더하기 연산자라면
				else {
					// stack이 빌 때까지 pop한 더하기를 postfix에 더해주고
				    while (!isEmpty()) {
				        postfix += pop();
				    }
				    // 해당 더하기를 하나 push하기
				    push(c);
				}

			}
			// for문이 끝난 후 stack이 빌 때까지 pop하고, postfix에 더해준다.
			while (!isEmpty()) {
			    postfix += pop();
			}
			
			
			// 완성된 postfix를 char형의 배열로 바꿔준다.
			char[] postfixArr = postfix.toCharArray();

			// 아래 정의한 메소드 calculatePostfix()에 postfixArr를 파라미터로 넣어 후위 표기식을 계산한다.
			System.out.printf("#%d %d\n", test_case, calculatePostfix(postfixArr));
			

		}

	}

	// 후위 표기식으로 바꾸기 위한 stack의 isEmpty()메소드
	public static boolean isEmpty() {
		return top == -1;
	}

	// 후위 표기식으로 바꾸기 위한 stack의 isFull()메소드
	public static boolean isFull() {
		return top == stack.length - 1;
	}

	// 후위 표기식으로 바꾸기 위한 stack의 peek()메소드
	public static char peek() {
		return stack[top];
	}

	// 후위 표기식으로 바꾸기 위한 stack의 pop()메소드
	public static char pop() {
		return stack[top--];
	}

	// 후위 표기식으로 바꾸기 위한 stack의 push()메소드
	public static void push(char plus) {
		stack[++top] = plus;
	}

	// 후위 표기식 계산을 위한 int_stack의 int_peek()메소드
	public static int int_peek() {
		return int_stack[int_top];
	}

	// 후위 표기식 계산을 위한 int_stack의 int_pop()메소드
	public static int int_pop() {
		return int_stack[int_top--];
	}

	// 후위 표기식 계산을 위한 int_stack의 int_push()메소드
	public static void int_push(int num) {
		int_stack[++int_top] = num;
	}

	// 변환한 후위 표기식을 계산하기 위한 calculatePostfix 메소드
	// 파라미터로 후위 표기식으로 변환한 char형의 배열이 입력된다.
	public static int calculatePostfix(char[] charArr) {

		// static으로 정의한 int_stack을 사용
		int_stack = new int[charArr.length];

		// charArr를 순회하며 c가 숫자인지 연산자인지 비교
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];

			// c가 숫자라면
			if (c >= '0' && c <= '9') {
				// c를 int형으로 변환하고, 0의 아스키 코드값(48)을 빼주고, int_stack에 push.
				int_push((int) c - 48);
			}

			// c가 더하기 연산자라면
			else {
				// int_stack에 쌓인 두 숫자를 차례대로 꺼내 연산을 수행
				int b = int_pop();
				int a = int_pop();
				// 연산이 끝나면 해당 값을 push하여 계산이 이어지도록
				int_push(a + b);

			}
		}

		return int_pop();
	}

}
