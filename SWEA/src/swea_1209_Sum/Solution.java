package swea_1209_Sum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_1209_Sum/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 테스트 케이스 번호 입력부분
			sc.nextInt();

			// 100 x 100 배열 초기화 
			int[][] arr = new int[100][100];
			
			
			// 배열값 입력받기
			for (int r=0; r<100; r++) {
				for (int c=0; c<100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			
			// 행 우선순회로 각 행의 합(row_sum)을 갱신
			for (int r=0; r<100; r++) {
				int row_sum = 0;
				for (int c=0; c<100; c++) {
					row_sum += arr[r][c];
				}
				// 각 행의 합을 max와 비교해 max를 갱신
				if (row_sum > max) {
					max = row_sum;
				}
			}
			
			// 열 우선순회로 각 열의 합(col_sum)을 갱신
			for (int c=0; c<100; c++) {
				int col_sum = 0;
				for (int r=0; r<100; r++) {
					col_sum += arr[r][c];
				}
				// 각 열의 합을 max와 비교해 max를 갱신
				if (col_sum > max) {
					max = col_sum;
				}
			}
			
			// (0,0), (1,1), (2,2), ... (99,99)의 대각원소의 합을 저장할 변수 dia_sum1
			int dia_sum1 = 0;
			// (0,99), (1,98), (2,97), ... (99,0)의 대각원소의 합을 저장할 변수 dia_sum2
			int dia_sum2 = 0;
			
			for (int i=0; i<100; i++) {
				dia_sum1 += arr[i][i];
			}
			
			for (int r=0; r<100; r++) {
				dia_sum2 += arr[r][99-r];
			}
			
			// max를 갱신
			if (dia_sum1 > max) {
				max = dia_sum1;
			}
			if (dia_sum2 > max) {
				max = dia_sum2;
			}

			System.out.printf("#%d %d\n", test_case, max);
			
			
		}
		
		
	}
}