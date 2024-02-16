package swea_1289_원재의메모리복구;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1289_원재의메모리복구/input.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수 입력
		int T = sc.nextInt();

		// 줄바꿈 입력
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 한줄로 입력받은 메모리 정보 String 배열로 하나씩 split.
			String[] memoryArr = sc.nextLine().split("");

			// 각 메모리값을 인덱스 순서대로 비교하며 다른 값을 마주칠 때마다 flag를 바꿔줄 것임.
			// 초기 flag는 0으로
			String flag = "0";

			// 출력할 정답
			int answer = 0;

			// memory 정보를 담은 배열을 순회
			for (int i = 0; i < memoryArr.length; i++) {
				// 메모리 값이 현재 flag와 같지 않다면
				if (!memoryArr[i].equals(flag)) {
					// 정답을 1 증가하고, flag값을 현재 메모리 정보로 교환
					answer++;
					flag = memoryArr[i];

				}

			}

			// 정답을 출력
			System.out.printf("#%d %d\n", test_case, answer);

		}

		sc.close();

	}

}
