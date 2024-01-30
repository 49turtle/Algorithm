package swea_1204_최빈수구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) throws FileNotFoundException {
		
//		System.setIn(new FileInputStream("src/swea_1204_최빈수구하기/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// Test 개수 입력
		int T = sc.nextInt();
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 각 테스트 케이스의 첫 줄에 테스트 케이스의 번호가 주어지므로 입력 한 번 받기 
			sc.nextInt();
			
			// 학생의 수 지정
			int numberOfStudents = 1000;
			
			// score를 카운팅할 배열 생성(0점 ~ 100점: 101개)
			int[] scoreCountArr = new int[101];
			
			
			// 1000명의 학생점수를 입력받아 카운팅 배열에 저장
			for (int i=0; i<numberOfStudents; i++) {
				int score = sc.nextInt();
				scoreCountArr[score]++;
			}
			
			// 카운팅 배열 중 최댓값을 찾고, 해당 값의 인덱스를 답으로 출력하기 위한 maxIdx 변수 선언
			int max = Integer.MIN_VALUE;
			int maxIdx = -1;
			
			// max와 같거나 크다면 갱신하는 반복문으로 최빈값이 여러 개인 경우 더 큰 점수를 갖고 오도록
			for (int i=0; i<101; i++) {
				if (scoreCountArr[i] >= max) {
					max = scoreCountArr[i];
					maxIdx = i;
				}
			}
			
			
			// 정답 출력
			int answer = maxIdx;
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}