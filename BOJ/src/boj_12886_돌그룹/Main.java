package boj_12886_돌그룹;

import java.util.Scanner;

public class Main {
	
	
	static int total;
	static boolean[][] visited;
	static boolean flag;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 초기 돌의 개수 입력받기
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		// 전체 돌의 개수의 합을 계산해 total에 저장
		total = A + B + C;
		
		// 강호가 돌을 같은 개수로 만들었는지 판단하는 변수 flag
		// true라면 돌을 같은 개수로 만들었음을 의미
		flag = false;
		
		// 이미 계산한 그룹인지를 방문 체크할 변수 선언
		// a, b 조합을 이미 방문했다면 해당 조합은 탐색하지 않아도 됨
		visited = new boolean[1501][1501];
		
		// 같은 개수의 돌로 쪼갤 수 있는 경우(돌 개수의 합이 3의 배수)에만 탐색 실시
		if (total % 3 == 0) {
			grouping(A, B);
			grouping(B, C);
			grouping(A, C);
		}
		
		// 강호가 돌을 같은 개수로 만들었다면 1을 출력
		if (flag) {
			System.out.println(1);
		}
		// 아니라면 0을 출력
		else {
			System.out.println(0);
		}
		
	}
	
	static void grouping(int a, int b) {

		if (a == b) {
			if (a == total/3) {
				flag = true;
				return;
			}
			else {
				visited[a][b] = true;
				grouping(a, total - a - b);
			}
		}
		
		if (flag || visited[a][b] || visited[b][a]) {
			return;
		}

		
		else {
			
			if (!visited[a][b] || !visited[b][a]) {
				
				visited[a][b] = true;
				visited[b][a] = true;
				
				
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				
				
				int nA = min + min;
				int nB = max - min;
				int nC = total - nA - nB;
				
				grouping(nA, nB);
				grouping(nA, nC);
				grouping(nB, nC);
				
				
				
				
			}	
		}
	}
	
	
	
	
	

}
