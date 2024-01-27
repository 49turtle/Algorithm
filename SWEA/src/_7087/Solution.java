package _7087;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public static void main(String args[]) throws Exception {
		
		
		
		
		
		System.setIn(new FileInputStream("SWEA/src/_7087/sample_input.txt"));

		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int T = Integer.parseInt(bf.readLine());
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(bf.readLine());
			
			
			
			char[] title_arr = new char[N];
			
			
			List<Character> title_list = new ArrayList<>();
			
			
			for (int i=0; i<N; i++) {
				String title = bf.readLine();
				title_list.add(title.charAt(0));
			}
			
			
			
			
			int answer = 0;
			
			
			
			Collections.sort(title_list);
			
			
			
			int cnt = 0;
			
			int ascii = 'A';
			int ascii_compare = title_list.get(0) - ascii;
			int idx = 0;
			
			
			
			if (title_list.get(0) == 'A') {
				answer += 1;
			}
			
			while (title_list.get(0) == 'A' && ascii_compare <= 1 && idx < title_list.size()) {
				
				
				
				ascii_compare = title_list.get(idx) - ascii;
				
				
				
				
				
				
				// 같다면
				if (ascii_compare == 0) {
				}
				
				// 1 차이가 난다면('
				else if (ascii_compare == 1) {
					answer += 1;
					ascii++;
				}
				
				
				
				idx++;
				
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			

		}
	}
}