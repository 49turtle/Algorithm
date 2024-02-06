package swea_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 전체 테스트 케이스 개수 입력받기
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 괄호 문자열을 입력받아 char형의 배열로 생성
			char[] bracketArr = sc.next().toCharArray();

			
			// 배열을 순회하며 현재 위치에 쌓여있는 pipe 개수의 총합을 나타내는 변수 pipeSum
			int pipeSum = 0;

			// 자른 쇠막대기의 수(출력하고자 하는 답)
			int answer = 0;

			
			// i는 0부터 전체길이 -1 전까지 순회(cNext 존재 때문)
			for (int i = 0; i < bracketArr.length - 1; i++) {
				// 현재 문자를 c로 저장
				char c = bracketArr[i];
				// 현재 문자 다음 문자를 cNext로 저장
				char cNext = bracketArr[i + 1];
				// 만약 c가 여는 괄호라면
				if (c == '(') {
					// c 다음 문자가 닫는 괄호라면 "레이저"이므로
					if (cNext == ')') {
						// 현재위치까지의 쇠막대기를 잘라 answer에 더해준다.
						answer += pipeSum;
					} else {
						// "레이저"가 아니라면 새로운 쇠막대기가 추가되는 것이므로 pipeSum을 1증가
						pipeSum++;
					}
				}

				// 만약 c가 닫는 괄호라면
				else {
					// 첫번째 문자를 제외하고, 두번째 문자부터
					// 바로 전 위치의 문자가 ')'였다면 "레이저"가 아니므로
					// 쇠막대기를 한 개 줄이고, 정답을 1 증가한다.
					if (i >= 1 && bracketArr[i - 1] == ')') {
						pipeSum--;
						answer++;
					}
				}

			}

			// 마지막 레이저로 잘린 쇠막대기의 개수를 추가로 더해주며 정답을 출력하면 끝
			System.out.printf("#%d %d\n", test_case, answer + pipeSum);

		}

	}
}
