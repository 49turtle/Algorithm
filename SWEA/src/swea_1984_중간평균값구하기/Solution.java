package swea_1984_중간평균값구하기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		
		
//		System.setIn(new FileInputStream("src/swea_1984_중간평균값구하기/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 문제 조건에 따라 10개의 수를 입력받을 arr를 선언
			int[] arr = new int[10];
			
			// arr에 순서대로 정수 입력 받기			
			for (int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			// 10개의 정수를 모두 더할 sum 변수 선언 및 0으로 초기화
			int sum = 0;
			// 최댓값, 최솟값을 구하기 위한 기준값 초기화
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			
			// arr 배열을 순회하며 원소 e를 모두 sum에 더하고
			for (int e : arr) {
				sum += e;
				// 만약 원소 e가 max보다 크다면 max를 갱신
				if (e > max) {
					max = e;
				}
				// 만약 원소 e가 min보다 작다면 min을 갱신
				if (e < min) {
					min = e;
				}
			}
			
			
			// 10개의 정수를 모두 더한 sum에서 max와 min을 뺀 변수 nominmax_sum을 계산
			int nominmax_sum = sum - (max + min);
			
			
			// nominmax_sum을 8.0으로 나누고 실수형으로 변환, %.0f로 소수점 반올림
			System.out.printf("#%d %.0f\n", test_case, (double)nominmax_sum/8.0);
			
			
		}
		
	}	

}
