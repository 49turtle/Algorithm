package boj_1337_올바른배열;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int maxAnswer = -1;

        for (int i=0; i<N; i++){
            int left = arr[i];
            int right = left+5;


            int answer = 1;

            for (int j=1; j<5; j++){

                if (i+j < N && right >= arr[i+j]){
//                    System.out.println("yes");
                    answer++;
                }
                else{
                    break;
                }
            }
//            System.out.println("left=" + left + ", right=" + right);
//            System.out.println("5-answer=" + (5-answer));

            maxAnswer = Math.max(answer, maxAnswer);

        }

        System.out.println(5-maxAnswer);



    }
}
