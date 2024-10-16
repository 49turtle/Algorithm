package boj_14235_크리스마스선물;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();

            for (int j = 0; j < a; j++) {
                pq.add(sc.nextInt());
            }

            if (a == 0) {
                if (!pq.isEmpty()) {
                    int present = pq.poll();
                    System.out.println(present);
                } else {
                    System.out.println(-1);
                }

            }
        }
    }
}
