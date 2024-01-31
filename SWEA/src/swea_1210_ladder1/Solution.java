package swea_1210_ladder1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

//		System.setIn(new FileInputStream("src/swea_1210_ladder1/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++) {

			// 테스트 케이스 번호 입력 받기
			sc.nextInt();
			
			// 100 x 100 행렬 입력받기
			int[][] arr = new int[100][100];
			for (int n=0; n<100; n++) {
				for (int m=0; m<100; m++) {
					arr[n][m] = sc.nextInt();
				}
			}
			
			// 현재 위치를 저장할 nr, nc 변수 선언 및 초기화
			int nr = 0;
			int nc = 0;
			
			// 마지막 행에서 숫자 2의 위치를 찾아 nr, nc를 갱신
			for (int i=0; i<100; i++) {
				if (arr[99][i] == 2) {
					nr = 99;
					nc = i;
				}
			}
			
			// nr이 0이 될때까지 반복(첫번째 행으로 사다리를 타고 올라올 때까지)
			while (nr != 0) {
				
				// 행을 우선 감소
				nr--;
				
				// 만약 열을 오른쪽으로 1칸 움직일 수 있고, 그 칸에 담긴 값이 1이라면 
				if (nc+1<100 && arr[nr][nc+1]==1) {
					// 범위를 벗어나거나 0을 마주칠 때까지 열을 1칸씩 증가
					while (nc+1<100 && arr[nr][nc+1]!=0) {
						nc++;
					}
				}
				// 만약 열을 왼쪽으로 1칸 움직일 수 있고, 그 칸에 담긴 값이 1이라면
				else if (nc-1>0 && arr[nr][nc-1]==1) {
					// 범위를 벗어나거나 0을 마주칠 때까지 열을 1칸씩 감소
					while (nc-1>0 && arr[nr][nc-1]!=0) {
						nc--;
					}
				}
			}
			
			// 결과를 출력(nc가 거슬러 온 열의 최종 위치이므로)
			System.out.printf("#%d %d\n", test_case, nc);
			
			
		}


	}
	
}