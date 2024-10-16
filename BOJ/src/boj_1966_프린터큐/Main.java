package boj_1966_프린터큐;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {

            // 문서의 개수
            int N = sc.nextInt();

            // Queue에서 몇 번째에 놓여있는지를 나타내는 정수
            int M = sc.nextInt();

            int[] arr = new int[N];

            Queue<int[]> queue = new LinkedList<>();

            int[] priorArr = new int[N];

            for (int i=0; i<N; i++){
                int prior = sc.nextInt();
                queue.add(new int[]{i, prior});
                priorArr[i] = prior;
            }

            int answer = 0;

            Arrays.sort(priorArr);
            int idx = N-1;

            while (!queue.isEmpty()){
                int[] temp = queue.poll();

                if (temp[1] == priorArr[idx]){
                    answer++;
                    if (temp[0] == M){
                        System.out.println(answer);
                        break;
                    }
                    idx--;
                }
                else{
                    queue.add(temp);
                }

            }


        }

    }
}
