package _1206;

import java.io.FileInputStream;
import java.util.Scanner;


public class Solution {
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("src/_1206/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			
			
			int[] arr = new int[N];
			
			
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(arr));
			
			int answer = 0;
			
			
			for (int i=2; i<N-2; i++) {

				int[] left_right = {arr[i]-arr[i-1], arr[i]-arr[i-2], arr[i]-arr[i+1], arr[i]-arr[i+2]};
				
				
				if (left_right[0]>0 && left_right[1]>0 && left_right[2]>0 && left_right[3]>0) {
					int min = Integer.MAX_VALUE;
					for (int k=0; k<4; k++) {
						if (left_right[k] < min) {
							min = left_right[k];
						}
						
					}
					answer += min;
				}
				
				
				
			}
			
			System.out.printf("#%d %d\n",test_case, answer);
			

		}
	}
}