package boj_1261_알고스팟;

import java.util.*;

public class Main {


    static class Point implements Comparable<Point>{
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point p){
            return this.cnt - p.cnt;
        }

    }


    static int[][] map;
    static int[][] dist;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[N][M];
        dist = new int[N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }


        for (int i=0; i<N; i++){
            String line = sc.next();

            char[] chArr = line.toCharArray();

            for (int j=0; j<M; j++){
                if (chArr[j] == '0'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = 1;
                }
            }
        }

        bfs(0, 0, 0);

        System.out.println(dist[N-1][M-1]);

    }

    static void bfs(int row, int col, int count){

        Point point = new Point(row, col, count);

        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(point);
        dist[row][col] = 0;

        while (!pq.isEmpty()){

            Point p = pq.poll();
//            System.out.println("r=" + p.r + ", c=" + p.c);


            int r = p.r;
            int c = p.c;
            int cnt = p.cnt;

            if (cnt > dist[r][c]){
                continue;
            }

            for (int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M){
                    int newCnt = cnt + map[nr][nc];
                    if (newCnt < dist[nr][nc]) {
                        dist[nr][nc] = newCnt;
                        pq.add(new Point(nr, nc, newCnt)); // 새로운 경로 추가
                    }
                }
            }
        }

        return;
    }



}
