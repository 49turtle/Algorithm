package boj_14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nr = Integer.parseInt(st.nextToken());
        int nc = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] checkArr = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int check = Integer.parseInt(st.nextToken());
                checkArr[r][c] = check == 1 ? -1 : 0;
            }
        }
		
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int answer = 0;
		
		while (true) {
			if (checkArr[nr][nc] == 0) {
				checkArr[nr][nc] = 1;
				answer++;
			}
			
			
			if (((nr-1 >= 0) && (checkArr[nr-1][nc] != 0)) &&
					((nc-1 >= 0) && (checkArr[nr][nc-1] != 0)) &&
					((nr+1 < N) && (checkArr[nr+1][nc] != 0)) &&
					((nc+1 < M) && (checkArr[nr][nc+1] != 0))) {
				if ((nr-dr[d] >= 0) && (nr-dr[d] < N) && (nc-dc[d] >= 0) && (nc-dc[d] < M) && (checkArr[nr-dr[d]][nc-dc[d]] != -1)) {
					nr -= dr[d];
					nc -= dc[d];
				}
				else {
					break;
				}
			}
			
			else {
				while(true) {
					d = (d-1 + 4) % 4;
					if ((nr+dr[d] >= 0) && (nr+dr[d] < N) && (nc+dc[d] >= 0) && (nc+dc[d] < N) && (checkArr[nr+dr[d]][nc+dc[d]] == 0)) {
						nr += dr[d];
						nc += dc[d];
						break;
					}
				}
				
			}
			
		}
		

				
		System.out.println(answer); 	
				
		br.close();
	}

}
