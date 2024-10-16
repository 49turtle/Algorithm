package boj_10815_숫자카드;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] cards = new int[N];

        for (int i=0; i<N; i++){
            cards[i] = sc.nextInt();
        }

        Arrays.sort(cards);

        int M = sc.nextInt();

        for (int i=0; i<M; i++){

            int num = sc.nextInt();

            int l = 0;
            int r = N-1;

            boolean flag = false;

            while (l <= r){

                int mid = l + (r-l)/2;

                if (num == cards[mid]){
                    flag = true;
                    System.out.print(1 + " ");
                    break;
                }

                if (num > cards[mid]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            if (!flag){
                System.out.print(0 + " ");
            }

        }

    }
}
