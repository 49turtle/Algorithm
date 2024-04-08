package swea_2117_홈방범서비스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	
	static int K;
	
	static int[][] map;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	static boolean[][] visited;
	
	static int house;
	static int ans;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			
			ans = -1;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					visited = new boolean[N][N];
					house = 0;
					bfs(r, c);
					
				}
			}
			
			
			System.out.println(ans);
			
			
			
		}
		
		
		
	}
	
	
	static void bfs(int row, int col) {
		
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int num = row*N+col;
		
		queue.add(num);
		
		int k = 0;
		
		while(!queue.isEmpty()) {
			
			System.out.println("큐 시작, k=" + k + ", row=" + row + ", col=" + col);
			
			int size = queue.size();
			

			
			for (int i=0; i<size; i++) {
				
				System.out.println("큐의 depth는?, k=" + k + ", size=" + size);
				
				int n = queue.poll();
				size--;
				
				int r = n / N;
				int c = n % N;
				
				if (map[r][c] == 1) {
					house++;
				}
				
				for (int d=0; d<4; d++) {
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
						queue.add(nr*N + nc);
						visited[nr][nc] = true;
					}
				}
				
			}
			
			k++;
			
			// 운영 비용
			int cost = 0;
			
			for (int i=0; i<k; i++) {
				cost += 2*i+1;
			}
			for(int i=0; i<k-1; i++) {
				cost += 2*i+1;
			}
			
			System.out.println("비용 낮니?");
			if (cost <= house * M) {
				ans = Math.max(ans, house);
				System.out.println("ans=" + ans);
			}
			
		}
		
		
		
		
		
	}
}
