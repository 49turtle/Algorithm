package swea_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 수

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 행의 수
            int M = sc.nextInt(); // 열의 수

            char[][] flagArr = new char[N][M];
            sc.nextLine(); // 개행 문자 제거

            // 국기 입력 받기
            for (int i = 0; i < N; i++) {
                flagArr[i] = sc.nextLine().toCharArray();
            }

            // 각 행에 대해 색상 변경 비용 계산
            int[][] cost = new int[N][3]; // 0: W, 1: B, 2: R
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (flagArr[i][j] != 'W') cost[i][0]++;
                    if (flagArr[i][j] != 'B') cost[i][1]++;
                    if (flagArr[i][j] != 'R') cost[i][2]++;
                }
            }

            int min = Integer.MAX_VALUE;

            // 가능한 모든 색상 구간 설정 시도
            for (int i = 0; i < N - 2; i++) { // 'W' 구간
                for (int j = i + 1; j < N - 1; j++) { // 'B' 구간
                    int answer = 0;
                    // 'W' 구간 변경 비용
                    for (int w = 0; w <= i; w++) {
                        answer += cost[w][0];
                    }
                    // 'B' 구간 변경 비용
                    for (int b = i + 1; b <= j; b++) {
                        answer += cost[b][1];
                    }
                    // 'R' 구간 변경 비용
                    for (int r = j + 1; r < N; r++) {
                        answer += cost[r][2];
                    }
                    // 최소값 갱신
                    if (answer < min) {
                        min = answer;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, min);
        }

        sc.close();
    }
}