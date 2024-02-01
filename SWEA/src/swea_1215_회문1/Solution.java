package swea_1215_회문1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1215_회문1/input.txt"));
		Scanner sc = new Scanner(System.in);
		

		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			int len = sc.nextInt();
			
			int cnt = 0;
			
			

			char[][] arr = new char[8][8];

			for (int i=0; i<8; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			
			 // 행 회문 확인
            for (int i=0; i<8; i++) {
                for (int j=0; j<=8-len; j++) {
                    boolean cnt_check = true;
                    for (int k=0; k<len/2; k++) {
                        if (arr[i][j+k] != arr[i][j+len-k-1]) {
                            cnt_check = false;
                            break;
                        }
                    }
                    if (cnt_check) {
                        cnt++;
                    }
                }
            }
			
			
			// 열 회문 확인
            for (int i=0; i<8; i++) {
                for (int j=0; j<=8-len; j++) {
                    boolean cnt_check = true;
                    for (int k=0; k<len/2; k++) {
                        if (arr[j+k][i] != arr[j+len-k-1][i]) {
                            cnt_check = false;
                            break;
                        }
                    }
                    if (cnt_check) {
                        cnt++;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);
		
		
		}

	}
}
