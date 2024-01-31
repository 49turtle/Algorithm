package swea_2001_파리퇴치;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_2001_파리퇴치/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++) {
			
			// N과 M을 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// N x N 배열 생성 후 입력받기
			int[][] arr = new int[N][N];
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			// M x M 행렬 원소 합의 max값을 찾기 위한 기준값
			int max = Integer.MIN_VALUE;
			
			// 행과 열을 0부터 N-M까지 증가(MxM 행렬의 시작점)
			for (int r=0; r<N-M+1; r++) {				
				for (int c=0; c<N-M+1; c++) {

					// 각 MxM 행렬의 원소의 합을 저장할 sum 변수 초기화
					int sum = 0;
					
					// MxM 행렬의 원소의 합을 계산
					for (int i=0; i<M; i++) {
						for (int j=0; j<M; j++) {
							sum += arr[r+i][c+j];
						}		
					}
					// max값 갱신
					if (sum > max) {
						max = sum;
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);

		}
	}
}