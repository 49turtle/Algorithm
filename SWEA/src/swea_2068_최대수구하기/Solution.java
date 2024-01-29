package swea_2068_최대수구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			// max값을 찾기 위해 기준값(MIN_VALUE)를 설정
			int max = Integer.MIN_VALUE;
			
			// 10개의 정수를 입력받을 arr를 선언
			int[] arr = new int[10];
			
			// 10개의 정수를 입력받으며 max와 비교해서 arr[i]가 max보다 크다면 max를 갱신 
			for (int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max) {
					max = arr[i];
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d\n", test_case, max);
		}
	}

}
