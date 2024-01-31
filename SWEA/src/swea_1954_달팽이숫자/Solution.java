package swea_1954_달팽이숫자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1954_달팽이숫자/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++) {
			
			// N 입력 받기
			int N = sc.nextInt();
			// N x N 행렬 생성, 원소 값은 0으로 초기화
			int[][] arr = new int[N][N];
			
			// 행렬 안에 1부터 차례대로 넣을 값 num을 생성
			int num = 1;
			
			// 행렬 내 현재 위치(행, 열)를 나타낼 nr, nc변수 선언
			int nr = 0;
			int nc = 0;
			
			// 델타 배열 선언(우하좌상 순서)
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			// 첫번째 칸에 1을 넣어줌
			arr[0][0] = num;
			
			// 델타 배열을 돌게끔하는 index i 선언
			int i = 0;
			// N제곱만큼의 배열을 채워야하므로 num이 N제곱보다 작을 때 while문을 실행
			while (num<N*N) {
				// 이동할 좌표가 범위 내에 있거나 이동할 좌표에 해당하는 원소의 값이 0일 때(아직 num이 채워지지 않은 곳일 때) 아래 while문을 실행
				while (nr+dr[i]>=0 && nr+dr[i]<N && nc+dc[i]<N && nc+dc[i]>=0 && arr[nr+dr[i]][nc+dc[i]]==0) {
					// 현재 위치를 이동
					nr += dr[i];
					nc += dc[i];
					// num을 증가시키고 현재 위치에 값을 저장
					arr[nr][nc] = ++num;
				}
				// 델타 배열의 인덱스를 이동(회전)
				i++;
				
				// 상 -> 우로 반복되기 위해 i가 4일 때 i를 다시 0으로 초기화
				if (i==4) {
					i=0;
				}
			}

			
			// 행 우선 순회로 2차원 배열 출력
			System.out.println("#"+test_case);
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}	
		}
	}
}