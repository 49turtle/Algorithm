package swea_1860_진기의최고급붕어빵;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// N: 손님의 수, M: 붕어빵 K개를 만들기 위해 필요한 시간(초), K: M초의 시간을 들였을 때 만들수 있는 붕어빵의 개수
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 손님이 도착하는 시간을 저장
			int[] arrivalTime = new int[N];
			for (int n=0; n<N; n++) {
				arrivalTime[n] = sc.nextInt();
			}
			
			// 손님이 도착할 시간을 오름차순으로 정렬
			Arrays.sort(arrivalTime);
			
			
			// 시간당 붕어빵을 만들 수 있는 개수
			int supply = 0;
			
			// answer는 Possible이 default가 되도록 설정
			String answer = "Possible";
			
			
			// 손님이 올 때마다 순회
			for (int i=0; i<N; i++) {
				// 각 시간별 supply(붕어빵을 얼마나 만들 수 있는가?)를 계산
				// 각 시간을 M으로 몫나누기를 실행하고, K를 곱해줌
				supply = arrivalTime[i]/M * K;
				
				// 해당 supply가 0번 손님부터~i번(현재) 손님까지의 붕어빵 제공(i+1개)이 불가능하다면 답을 impossible로!
				if (supply < i+1) {
					answer = "Impossible";
					break;
				}
				
			}
			
			
			System.out.printf("#%d %s\n", test_case, answer);
			
			
		}
		
		sc.close();
	}

}
