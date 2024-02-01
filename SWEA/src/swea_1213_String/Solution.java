package swea_1213_String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/swea_1213_String/test_input.txt"));
		Scanner sc = new Scanner(System.in);
		

		int T = 10;
		
		

		for (int test_case=1; test_case<=T; test_case++) {
			
			sc.nextLine();
			
			// pattern과 문자열을 입력받아 character형의 문자열로 변환
			char[] pattern = sc.nextLine().toCharArray();
			char[] str = sc.nextLine().toCharArray();
			
			// pattern의 등장 횟수를 저장할 변수 초기화(출력하고자 하는 정답)
			int answer = 0;
			
			
			
			for (int i=0; i<=str.length-pattern.length; i++) {
				// pattern이 str 내부에 존재하는지 판별할 신호의 기본값을 false로 초기화
				boolean flag = false;
				// str의 원소들을 순회하며 pattern 첫 글자와 일치한다면
				if (str[i] == pattern[0]) {
					// 패턴 나머지 문자들과 전부 일치하면 flag가 true를 저장하도록 설정
					for (int j=1; j<pattern.length; j++) {
						if (str[i+j] != pattern[j]) {
							flag = false;
							break;
						}
						else {
							flag = true;
						}
						
					}
					// flag가 true라면 answer에 1을 더한다.
					if (flag) {
						answer += 1;
					}
				}
				
				
				
			}
			
			
			System.out.printf("#%d %d\n", test_case, answer);
			
			
			
		}

	
	}
	


}

