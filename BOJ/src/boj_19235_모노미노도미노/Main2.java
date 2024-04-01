package boj_19235_모노미노도미노;

import java.util.Scanner;

public class Main2 {

	static int N;

	static int[][] greenMap;
	static int[][] blueMap;

	static int score;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		greenMap = new int[6][4];
		// blueMap을 돌려서 greenMap과 같은 로직을 수행하게끔...!
		blueMap = new int[6][4];

		for (int i = 0; i < N; i++) {

			int commandGreen = sc.nextInt();
			int rowGreen = sc.nextInt();
			int colGreen = sc.nextInt();
			
			
			int commandBlue = commandGreen;
			if (commandGreen == 2) {
				commandBlue = 3;
			}
			else if (commandGreen == 3) {
				commandBlue = 2;
			}
			
			int rowBlue = colGreen;
			int colBlue = 3 - rowGreen;
			
			if (commandBlue == 2) {
				colBlue--;
			}
			
			
//			System.out.println(commandBlue + " " + rowBlue + " " + colBlue);
			
			moveBlock(greenMap, rowGreen, colGreen, commandGreen);
			moveBlock(blueMap, rowBlue, colBlue, commandBlue);
			
			
			while (isFull(greenMap)) {
				getScore(greenMap);
				dropBlocks(greenMap);
			}
			
			
//			printMap(greenMap);
			
			while(isFull(blueMap)) {
				getScore(blueMap);
				dropBlocks(blueMap);
			}
			
            
            clearLight(greenMap);
            clearLight(blueMap);
			
			
			
            

		}
		System.out.println(score);
		System.out.println(countBlocks(greenMap) + countBlocks(blueMap));

	}
	private static void dropBlocks(int[][] map) {
	    for (int col = 0; col < 4; col++) {
	        for (int row = 4; row >= 0; row--) {
	            if (map[row][col] == 1) {
	                int nextRow = row;
	                while (nextRow + 1 < 6 && map[nextRow + 1][col] == 0) {
	                    // 아래로 이동 가능한 최대 거리
	                    nextRow++;
	                }
	                if (nextRow != row) {
	                    map[nextRow][col] = 1; // 아래로 이동
	                    map[row][col] = 0; // 원래 위치의 블록을 제거
	                }
	            }
	        }
	    }
	}


	private static int countBlocks(int[][] map) {
		int cnt = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void clearLight(int[][] map) {

		int inLightColor = 0;
		for (int i = 0; i < 4; i++) {
			if (map[0][i] == 1) {
				inLightColor++;
				break;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (map[1][i] == 1) {
				inLightColor++;
				break;
			}
		}

		if (inLightColor > 0) {
			int move = inLightColor;
			for (int r = 5; r >= move; r--) {
				for (int c = 0; c < 4; c++) {
					map[r][c] = map[r - move][c];
				}
			}
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < 4; c++) {
					map[r][c] = 0;
				}
			}

		}
	}

	
	
	private static boolean isFull(int[][] map) {
		for (int i=0; i<6; i++) {
			boolean isFull = true;
			for (int j=0; j<4; j++) {
				if (map[i][j] == 0) {
					isFull = false;
				}
			}
			if (isFull) {
				return true;
			}
		}
		return false;
	}
	
	

	
	
	
	private static void getScore(int[][] map) {

		for (int i = 0; i < 6; i++) {
			int idx = 0;
			boolean isFull = true;
			while (idx < 4) {
				if (map[i][idx] == 0) {
					isFull = false;
				}
				idx++;
			}
			if (isFull) {
				for (int j = i; j >= 0; j--) {
					for (int c = 0; c < 4; c++) {
						if (j == 0) {
							map[j][c] = 0;
						} else {
							map[j][c] = map[j - 1][c];
						}
					}
				}
				score++;
			}
		}
	}

	private static void moveBlock(int[][] map, int row, int col, int command) {

		if (command == 1) {
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					map[i][col] = 1;
					break;
				}
				if (map[i][col] == 0 && map[i + 1][col] == 1) {
					map[i][col] = 1;
					break;
				}
			}
		}

		else if (command == 2) {
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					map[i][col] = map[i][col + 1] = 1;
					break;
				}
				if ((map[i][col] == 0 && map[i][col + 1] == 0)
						&& (map[i + 1][col] == 1 || map[i + 1][col + 1] == 1)) {
					map[i][col] = map[i][col + 1] = 1;
					break;
				}
			}
		}

		else {
			for (int i = 0; i < 6; i++) {
				if (i == 4) {
					map[i][col] = map[i + 1][col] = 1;
					break;
				}
				if (map[i][col] == 0 && map[i + 1][col] == 0 && map[i + 2][col] == 1) {
					map[i][col] = map[i + 1][col] = 1;
					break;
				}
			}
		}
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
}
