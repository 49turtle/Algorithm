package boj_19637_IF문좀대신써줘;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 칭호의 개수
        int M = Integer.parseInt(st.nextToken());  // 캐릭터의 수

        int[] numGrade = new int[N];
        String[] nameGrade = new String[N];

        // 칭호와 전투력 상한값 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            numGrade[i] = num;
            nameGrade[i] = name;
        }

        // 캐릭터의 전투력 입력 및 이분 탐색을 통해 칭호 출력
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());

            // 이분 탐색
            int l = 0;
            int r = N - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (input <= numGrade[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // l이 가리키는 칭호를 StringBuilder에 추가
            sb.append(nameGrade[l]).append("\n");
        }

        // 결과 한 번에 출력
        System.out.print(sb.toString());
    }
}
