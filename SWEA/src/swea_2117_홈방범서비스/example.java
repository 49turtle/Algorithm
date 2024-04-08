package swea_2117_홈방범서비스;

import java.util.LinkedList;
import java.util.Queue;

public class example {

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	

	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		int N = 5;
		
		int[][] map = new int[5][5];
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				
				int[][] copyMap = mapCopy(map);
				bfs(copyMap, i, j, 2);
				System.out.println("---end---");
			}
		}
		
		
		
	}
	
	
	static void bfs(int[][] map, int row, int col, int limit) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = map.length;
		
		
		visited = new boolean[N][N];
		
		
		map[row][col] = 1;
		visited[row][col] = true;
		
		int num = row*N+col;
		
		int depth = 0;
		
		queue.add(num);
		
		
		
		
		while(!queue.isEmpty()) {
			
			if (depth == limit) {
				break;
			}
			
			int size = queue.size();
			System.out.println(queue);
			
			
			for (int i=0; i<size; i++) {
				
				int n = queue.poll();
				
				
				int r = n / N;				
				int c = n % N;
				
				
				for (int d=0; d<4; d++) {
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
						
						queue.add(nr*N + nc);
						
						map[nr][nc] = 1;
						visited[nr][nc] = true;
					}
					
				}
				
			}

			printMap(map);
			
			depth++;
			
		}
		System.out.println(depth);
		
		
		
		
	}
	
	
	static void printMap(int[][] map) {
		System.out.println("---start---");
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	static int[][] mapCopy(int[][] map) {
		
		int[][] copyMap = new int[map.length][map[0].length];
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	
	
	
}
