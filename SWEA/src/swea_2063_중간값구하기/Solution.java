package swea_2063_중간값구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		System.setIn(new FileInputStream("src/swea_2063_중간값구하기/input.txt"));
		
		Scanner sc = new Scanner(System.in);
	
		// 입력받을 배열의 길이 입력받기(N은 홀수)
		int N = sc.nextInt();
		
		// N만큼의 길이를 가진 배열을 생성
		int[] arr = new int[N];
		
		// 배열 안에 값 입력받아 저장하기
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// N/2까지 선택 정렬 구현(N은 홀수이므로 N/2까지 실행하고 arr[N/2]를 출력하면 정답을 구할 수 있음)
		for (int i=0; i<=N/2; i++) {
			// min을 첫번째 for문 안에 초기화하여 각 반복마다 min값을 갱신
			int min = Integer.MAX_VALUE;
			// 기준값 뒤의 배열값을 비교하며 min값과 기준값을 swap
			for (int j=i+1; j<N; j++) {
				if (arr[j] < min) {
					min = arr[j];
					arr[j] = arr[i];
					arr[i] = min;
				}
			}
		}
		
		// 중간값에 해당하는 원소값 출력
		System.out.println(arr[N/2]);
	}
}
