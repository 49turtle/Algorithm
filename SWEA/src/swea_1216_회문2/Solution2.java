package swea_1216_회문2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1216_회문2/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			sc.nextInt();

			int cnt = 0;

			char[][] arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.next().toCharArray();
			}

			int max_len = -1;

			
			
			// 행 회문 확인

			for (int i = 0; i < 100; i++) {
				for (int len = 1; len < 101; len++) {
					for (int j = 0; j <= 100 - len; j++) {
						boolean cnt_check = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[i][j + k] != arr[i][j + len - k - 1]) {
								cnt_check = false;
								break;
							}
						}
						if (cnt_check) {
							if (len > max_len) {
								max_len = len;
							}
						}
					}
				}
			}

			// 열 회문 확인

			for (int i = 0; i < 100; i++) {
				for (int len = 1; len < 101; len++) {
					for (int j = 0; j <= 100 - len; j++) {
						boolean cnt_check = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[j + k][i] != arr[j + len - k - 1][i]) {
								cnt_check = false;
								break;
							}
						}
						if (cnt_check) {
							if (len > max_len) {
								max_len = len;
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + max_len);

		}

	}
}