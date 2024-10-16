package boj_13335_트럭;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int n = sc.nextInt();  // 트럭 수
        int w = sc.nextInt();  // 다리 길이
        int L = sc.nextInt();  // 최대 하중

        int[] trucks = new int[n];  // 트럭 무게 배열
        for (int i = 0; i < n; i++) {
            trucks[i] = sc.nextInt();
        }

        // 시뮬레이션을 위한 큐: (트럭 무게, 다리에 진입한 시간)
        Queue<int[]> bridge = new LinkedList<>();
        int time = 0;  // 총 경과 시간
        int bridgeWeight = 0;  // 현재 다리 위 트럭들의 총 무게
        int idx = 0;  // 다음에 올라갈 트럭 인덱스

        // 시뮬레이션 시작
        while (idx < n || !bridge.isEmpty()) {
            time++;  // 시간 경과

            // 다리 끝에 도달한 트럭 제거
            if (!bridge.isEmpty() && time - bridge.peek()[1] >= w) {
                bridgeWeight -= bridge.poll()[0];  // 무게 감소
            }

            // 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (idx < n && bridgeWeight + trucks[idx] <= L) {
                // 트럭을 다리에 올림
                bridge.add(new int[]{trucks[idx], time});
                bridgeWeight += trucks[idx];
                idx++;  // 다음 트럭으로 이동
            }
        }

        // 최종 경과 시간 출력
        System.out.println(time);

    }
    
    
}
