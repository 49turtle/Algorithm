package boj_1890_점프;

import java.util.Scanner;

public class Main {

	static long[][] pathMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] map = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		pathMap = new long[N][N];

		pathMap[0][0] = 1;

		int jump = map[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				

//				printMap(pathMap);
				
				if (pathMap[i][j] != 0 && map[i][j] != 0) {
					jump = map[i][j];
					if (i+jump < N) {
						pathMap[i+jump][j] += pathMap[i][j];
					}
					if (j+jump < N) {
						pathMap[i][j+jump] += pathMap[i][j];
					}
				}

			}
		}

		System.out.println(pathMap[N - 1][N - 1]);

	}
	
//	static void printMap(int[][] map) {
//		System.out.println("---start---");
//		for (int i=0; i<map.length; i++) {
//			for (int j=0; j<map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//	}

}
