package swea_1966_숫자를정렬하자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 삽입 정렬
			int[] sortedArr = InsertionSort(arr);

			
			
			System.out.printf("#%d ", test_case);
			
			for (int i=0; i<N; i++) {
				System.out.print(sortedArr[i] + " ");
			}
			System.out.println();
			

		}

		sc.close();
	}

	public static int[] InsertionSort(int[] data) {

		// 정렬되지 않은 집합(U)의 원소를 하나씩 순회
		for (int i = 1; i < data.length; i++) {
			int key = data[i];

			int j;

			// 정렬된 집합(S)의 원소와 뒤에서부터 비교하면서 위치를 찾는다.
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}

			data[j + 1] = key;
		}

		return data;

	}

}
