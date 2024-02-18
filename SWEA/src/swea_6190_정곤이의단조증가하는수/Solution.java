package swea_6190_정곤이의단조증가하는수;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_6190_정곤이의단조증가하는수/s_input.txt"));

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 입력받을 수의 개수 N 입력
			int N = sc.nextInt();

			// 입력받은 수를 array에 저장
			int[] numArr = new int[N];
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = sc.nextInt();
			}

			// answer의 default를 -1로 설정
			int answer = -1;

			// numArr를 순회하면서 사용자 정의 메소드 checkMonoInc()를 실행해 answer의 최댓값 갱신
			for (int i = 0; i < numArr.length - 1; i++) {
				for (int j = i + 1; j < numArr.length; j++) {
					int num = checkMonoInc(numArr[i] * numArr[j]);

					if (num > answer) {
						answer = num;
					}
				}
			}

			// 정답 출려
			System.out.printf("#%d %d\n", test_case, answer);
		}

		sc.close();
	}

	
	// 사용자 정의 메소드 checkMonoInc() 정의
	// 파라미터로 int형의 숫자를 넣어줌
	public static int checkMonoInc(int num) {

		// ArrayList로 구현된 numList 생성
		List<Integer> numList = new ArrayList<Integer>();

		// 숫자를 담아둘 temp 변수 선언
		int temp = num;

		// temp가 0보다 작아질 때까지
		while (temp > 0) {
			// numList에 num의 최고 자리 숫자부터 하나씩 add
			numList.add(temp % 10);
			temp /= 10;
		}

		// numList를 하나씩 돌면서 단조 감소하는지 확인(최고 자리 숫자부터 일의 자리 숫자 순서대로 담겨있으므로)
		int k = numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			if (k < numList.get(i)) {
				// 만약 증가한다면 -1을 리턴
				return -1;
			}
			k = numList.get(i);

		}
		// input으로 들어온 num을 그대로 리턴
		return num;

	}

}
