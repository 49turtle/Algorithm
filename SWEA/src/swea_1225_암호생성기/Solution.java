package swea_1225_암호생성기;

import java.util.Scanner;

public class Solution{
	
	// 숫자들이 담길 arr 선언
	static int[] arr = new int[8];
	// doCycle 메소드를 반복하며 숫자 값이 0 이하가 되어 반복을 종료하고, 마지막에 위치하게 될 숫자의 인덱스를 의미
	static int endIdx = -1;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 문제에 나와있지 않지만, 테스트 케이스가 10개라고 함.
		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			// 테스트 케이스 번호를 입력받음
			sc.nextInt();
			
			// arr에 숫자 8개를 입력받음
			for (int i=0; i<8; i++) {
				arr[i] = sc.nextInt();
			}
			
			// doCycle 메소드를 실행
			// 입력받은 arr를 0부터 doCycle 실행
			doCycle(arr, 0);
			
			
			// 결과를 출력
			System.out.printf("#%d ", test_case);
			// static 변수인 endIdx의 7개 전의 index부터 총 8개를 연달아 출력(endIdx가 마지막에 출력되도록)
			for (int i=endIdx-7; i<=endIdx; i++) {
				System.out.print(arr[(i+8)%8] + " ");
			}
			// 줄바꿈
			System.out.println();
			
			
		}
		
		sc.close();
			
		
	}
	
	
	
	// arr의 idx부터 시작하는 cycle을 의미하는 메소드 doCycle
	// arr의 idx에 위치하는 숫자를 1씩 감소, idx를 1씩 증가하며 각각 2, 3, 4, 5를 감소
	public static void doCycle(int[] arr, int idx) {
		// 숫자를 감소시킬 값 k
		int k = 1;
		// 파라미터 idx부터 idx+5 전까지 반복을 실행
		for (int i=idx; i<idx+5; i++) {
			// i가 arr의 인덱스를 초과할 수 있으므로 i%8로 인덱스를 조정하며 k만큼 감소
			arr[i%8] = arr[i%8] - k;
			// 만약 숫자가 0이하가 된다면 endIdx를 갱신하고, 함수를 중단.
			if (arr[i%8] <= 0) {
				arr[i%8] = 0;
				endIdx = i%8;
				return;
			}
			k++;
		}
		// 재귀함수로 다음 cycle을 반복
		doCycle(arr, (idx+5)%8);
	}
}