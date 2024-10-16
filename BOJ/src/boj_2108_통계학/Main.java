package boj_2108_통계학;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int sum = 0;

        int[] cntArr = new int[8001];


        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            sum += num;

            cntArr[num + 4000]++;

            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }

            arr[i] = num;

        }

        int avg = Math.round(sum / (float) N);

        System.out.println(avg);

        Arrays.sort(arr);

        int mid = arr[N / 2];
        System.out.println(mid);


        int cntMax = Integer.MIN_VALUE;
        for (int i = 0; i < cntArr.length; i++) {
            int cnt = cntArr[i];
            if (cntMax < cnt) {
                cntMax = cnt;
            }
        }

        List<Integer> freqList = new ArrayList<>();


        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == cntMax) {
                freqList.add(i - 4000);
            }
        }

        Collections.sort(freqList);

        if (freqList.size() > 1) {
            System.out.println(freqList.get(1));
        } else {
            System.out.println(freqList.get(0));
        }

        int range = max - min;

        System.out.println(range);


    }

}


