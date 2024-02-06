package swea_1217_거듭제곱;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 개수는 10개
		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 테스트 케이스의 번호 입력
			sc.nextInt();
			
			// 숫자 N을 M번 거듭제곱하려 함
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 결과 출력
			System.out.printf("#%d %d\n", test_case, calcPower(N, M));
			
		}
		
		
	}
	
	
	
	
	// 거듭제곱을 계산하는 메소드 calcPower(N, M)
	public static int calcPower(int N, int M) {
		
		// Base Case: N의 1제곱은 N이므로
		if (M==1) {
			return N;
		}
		
		// Recursive Case: (N의 M-1제곱)*N
		return calcPower(N, M-1) * N;
		
	}
	
}
