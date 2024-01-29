package swea_1210_View;

import java.io.FileInputStream;
import java.util.Scanner;


public class Solution {
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/swea_1210_View/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 건물의 개수 N 입력
			int N = sc.nextInt();
			
			// N개의 건물의 높이를 저장할 arr 배열 선언
			int[] arr = new int[N];
			
			// 건물의 높이를 입력받아 arr에 순서대로 저장
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 조망권이 확보된 세대 수(출력할 정답)
			int answer = 0;
			
			// 맨 왼쪽, 오른쪽 두 칸에는 건물이 지어지지 않으므로
			// i는 2부터 N-3까지 증가
			for (int i=2; i<N-2; i++) {
				
				// 각 건물을 기준으로 좌우 2칸씩의 건물 높이 차이(건물i의 높이-좌우 2칸 건물의 높이)를 배열로 저장
				int[] left_right = {arr[i]-arr[i-2], arr[i]-arr[i-1], arr[i]-arr[i+1], arr[i]-arr[i+2]};
				
				// 좌우 2칸씩의 건물과의 높이 차이가 모두 양수라면(조망권이 확보됐다면)
				if (left_right[0]>0 && left_right[1]>0 && left_right[2]>0 && left_right[3]>0) {
					// 높이 차이 중 min값을 찾아 answer에 더해준다.
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
		sc.close();
	}
}
