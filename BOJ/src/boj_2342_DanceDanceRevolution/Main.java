package boj_2342_DanceDanceRevolution;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][][] arr = new int[5][5][100001];

		int k = 0;

		int num = sc.nextInt();

		
		if (num == 0) {
			System.out.println(0);
			return;
		}
		
		
		while (num != 0) {

			
			for (int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					arr[i][j][k] = Integer.MAX_VALUE;
				}
			}
			
			
			if (k == 0) {
				arr[0][num][k] = 2;
				arr[num][0][k] = 2;
			}

			
			else {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {

						if (arr[i][j][k - 1] != Integer.MAX_VALUE) {

							
							if (num == i || num == j) {
								arr[i][j][k] = arr[i][j][k - 1] + 1;
							}
							
							
							else {								
								if (i == 0) {
									arr[num][j][k] = Math.min(arr[num][j][k], arr[i][j][k - 1] + 2);
									
									if (Math.abs(num - j) == 2) {
										arr[i][num][k] = Math.min(arr[i][num][k], arr[i][j][k - 1] + 4);
									} else {
										arr[i][num][k] = Math.min(arr[i][num][k], arr[i][j][k - 1] + 3);
									}
								} else if (j == 0) {
									arr[i][num][k] = Math.min(arr[i][num][k], arr[i][j][k - 1] + 2);
									
									if (Math.abs(num - i) == 2) {
										arr[num][j][k] = Math.min(arr[num][j][k], arr[i][j][k - 1] + 4);
									} else {
										arr[num][j][k] = Math.min(arr[num][j][k], arr[i][j][k - 1] + 3);
									}
								}
								
								else {
									
									if (Math.abs(num - i) == 2) {
										arr[num][j][k] = Math.min(arr[num][j][k], arr[i][j][k - 1] + 4);
										arr[i][num][k] = Math.min(arr[i][num][k], arr[i][j][k - 1] + 3);
									} else {
										arr[num][j][k] = Math.min(arr[num][j][k], arr[i][j][k - 1] + 3);
										arr[i][num][k] = Math.min(arr[i][num][k], arr[i][j][k - 1] + 4);
									}
									
									
								}
							}

						}
					}
				}
			}
			
			k++;

			num = sc.nextInt();
		}
		
		
		
		
		int answer = Integer.MAX_VALUE;
		
		for (int i=0; i<5; i++) {
//			System.out.println();
			for (int j=0; j<5; j++) {
//				System.out.print(arr[i][j][k-1] + " ");
				
				if (answer > arr[i][j][k-1]) {
					answer = arr[i][j][k-1];
				}
			}
		}
		
		System.out.println(answer);
		
		
		
		
		

	}
}
