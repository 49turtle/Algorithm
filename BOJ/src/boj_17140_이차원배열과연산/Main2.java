package boj_17140_이차원배열과연산;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

	static PriorityQueue<int[]> queue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int k = sc.nextInt();

		int[][] arr = new int[100][100];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int sec = 0;

		int answer = -1;

		while (sec < 100) {
			if (arr[r][c] == k) {
				answer = sec;
				break;
			}
			sec++;

			if (isOperationR(arr)) {
				for (int i = 0; i < arr.length; i++) {
					queue = new PriorityQueue<int[]>((arr1, arr2) -> {
						if (arr1[1] == arr2[1]) {
							return arr1[0] - arr2[0]; // 빈도수가 같으면 값이 작은 순으로 정렬
						} else {
							return arr1[1] - arr2[1]; // 빈도수가 작은 순으로 정렬
						}
					}); 
					int[] newArr = operation(arr[i]);

					for (int j = 0; j < arr[i].length; j++) {
						arr[i][j] = newArr[j];
					}

				}
			} else {

				for (int i = 0; i < arr[0].length; i++) {
					int[] colArr = new int[arr[0].length];
					for (int j = 0; j < arr.length; j++) {
						colArr[j] = arr[j][i];
					}

					int[] newArr = operation(colArr);

					for (int j = 0; j < arr[i].length; j++) {
						arr[j][i] = newArr[j];
					}

				}
			}

		}

		System.out.println(answer);

//		System.out.println(Arrays.toString(arr[0]));

		sc.close();

	}

	static int[] operation(int[] arr) {

		int[] cntArr = new int[101];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				cntArr[arr[i]]++;
			}
		}

		for (int i = 0; i < cntArr.length; i++) {
			if (cntArr[i] != 0) {
				int[] freqArr = { i, cntArr[i] };
				queue.add(freqArr);
			}
		}

		int idx = 0;

		while (!queue.isEmpty()) {
			int[] tempArr = queue.poll();
//			System.out.println(Arrays.toString(tempArr));
			if (idx >= 100) {
				break;
			}
			arr[idx++] = tempArr[0];
			arr[idx++] = tempArr[1];

		}

		Arrays.fill(arr, idx, arr.length, 0); // idx 이후 모든 요소를 0으로 설정
		return arr;
	}

	static boolean isOperationR(int[][] arr) {
		int maxRowLength = 0;
		for (int i = 0; i < arr.length; i++) {
			int rowLength = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					rowLength = j + 1;
				}
			}
			maxRowLength = Math.max(maxRowLength, rowLength);
		}

		int maxColLength = 0;
		for (int i = 0; i < arr[0].length; i++) {
			int colLength = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					colLength = j + 1;
				}
			}
			maxColLength = Math.max(maxColLength, colLength);
		}

		return maxRowLength >= maxColLength;
	}

}
