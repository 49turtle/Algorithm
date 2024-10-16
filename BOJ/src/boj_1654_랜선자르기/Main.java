package boj_1654_랜선자르기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] lans = new int[K];

        long maxLen = Long.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            lans[i] = sc.nextInt();
            if (maxLen < lans[i]) {
                maxLen = lans[i];
            }
        }

        long l = 1;
        long r = maxLen;

        long result = 0;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += lans[i] / mid;
            }

            if (cnt < N) {
                r = mid - 1;
            } else {
                l = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }

}
