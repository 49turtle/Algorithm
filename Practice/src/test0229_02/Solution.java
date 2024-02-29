package test0229_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Queue<Integer> queue;
	static List<Integer> heightR;
	static List<Integer> heightC;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			
			N = sc.nextInt();
			int K = sc.nextInt();
			
			map = new int[N][N];
			
			int maxHeight = -1;
			
			for (int i=0; i<map.length; i++) {
				for (int j=0; j<map[i].length; j++) {
					
					map[i][j] = sc.nextInt();
					
					if (map[i][j] > maxHeight) {
						maxHeight = map[i][j];
					}
					
				}
			}
			
			
			heightR = new ArrayList<Integer>();
			heightC = new ArrayList<Integer>();
			
			
			for (int i=0; i<map.length; i++) {
				for (int j=0; j<map[i].length; j++) {
					if (map[i][j] == maxHeight) {
						heightR.add(i);
						heightC.add(j);
					}
				}
			}
			
			queue = new LinkedList<Integer>();
			
			
			
			int max = Integer.MIN_VALUE;
			
			for (int i=0; i<map.length; i++) {
				for (int j=0; j<map[i].length; j++) {
					if (map[i][j] != maxHeight) {
						
						map[i][j] = map[i][j] - K;
						
						for (int k=0; k<heightR.size(); k++) {
							int topR = heightR.get(k);
							int topC = heightC.get(k);
							int roadLen = findRoad(topR, topC);
							if (roadLen > max) {
								max = roadLen;
							}
						}
						
						map[i][j] = map[i][j] + K;
						
						
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);
			
			
			
			
			
		}
		
		
		
		
		
		
		sc.close();
		
		
	}
	
	
	
	
	// 봉우리 기준으로 퍼져나가기
	static int findRoad(int row, int col) {
		
		int cnt = 0;
		
		int[][] roadMap = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				roadMap[i][j] = Integer.MAX_VALUE;
			}
		}
		
		roadMap[row][col] = 0;
		
		int locNum = row*N + col;
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1}; 
		
		queue.add(locNum);
		
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			
			
			int nr = num / N;
			int nc = num % N;
			
			
			
			
			for (int d=0; d<4; d++) {
				if (nr+dr[d] >= 0 && nr+dr[d] < N && nc+dc[d] >= 0 && nc+dc[d] < N && map[nr+dr[d]][nc+dc[d]] < map[nr][nc] && !queue.contains((nr+dr[d])*N + nc+dc[d])) {
					queue.add((nr+dr[d])*N + nc+dc[d]);
					
					if (roadMap[nr][nc] < cnt+1) {
						roadMap[nr][nc] = cnt+1;
					}
					
				}
			}
			
		}
		
		
		return cnt;
		
	}
	
	
	
	
	
	
	
	
	
}
