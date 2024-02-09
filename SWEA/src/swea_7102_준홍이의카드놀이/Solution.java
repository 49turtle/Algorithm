package swea_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 문제의 N, M 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// n + m의 경우의 수를 행렬로 표현한다면 N x M으로 표현이 가능
			int row = 0;
			int col = 0;
			
			// N과 M 중 더 작은 값을 row로 설정, 큰 값을 col로 설정
			if (N <= M) {
				row = N;
				col = M;
			}
			else {
				row = M;
				col = N;
			}
			
			// |N - M|은 큰 값인 col에서 row를 빼는 것이므로 absMinus를 아래와 같이 선언
			int absMinus = col - row;
			// N x M 행렬에서 제일 긴 대각원소들(오른쪽 위에서 왼쪽 아래로 내려오는 대각 방향)이 최대 빈도 값들이 되고
			// 각 값들은 min(N, M)+1부터 시작하며 1씩 증가 
			int freqVal = row + 1;
			
			// 테스트 케이스 번호를 먼저 출력
			System.out.printf("#%d ", test_case);
			
			// |N-M|+1이 0이 될 때까지 출력을 반복
			// |N-M|+1: N x M 행렬에서 가장 긴 대각선이 나오는 개수
			// 즉, 등장할 확률이 가장 높은 것들의 총 개수만큼 반복
			while(absMinus+1>0) {
				absMinus--;
				// freqVal를 1씩 증가하며 연달아 출력
				System.out.printf("%d ", freqVal++);
			}
			// 줄바꿈
			System.out.println();
			
		}
		
		sc.close();
		
	}
}