package _4047;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("src/_4047/sample_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 0: S, 1: D, 2: H, 3: C
			int[] s_count = new int[13];
			int[] d_count = new int[13];
			int[] h_count = new int[13];
			int[] c_count = new int[13];
			
			
			String error = "not error";
			
			
			String str = sc.nextLine();
			
			
			
			
			
//			System.out.println(str.substring(0,3));
			
//			char[] arr = new char[str.length()];
//			
//			for (int i=0; i<str.length(); i++) {
//				arr[i] = str.charAt(i);
//			}
//			System.out.println(arr[0]);
//			
//			System.out.println((int) arr[1]);
			
			
			for (int i=0; i<str.length(); i+=3) {
				
				
				
				String sub_str = str.substring(i, i+3); 
				
				char card = sub_str.charAt(i%3);
				char ten_num = sub_str.charAt(i%3 + 1);
				char one_num = sub_str.charAt(i%3 + 2);
				
				if (card == 'S') {
					
					
					if (ten_num == '0') {
						
						if (one_num == '1') {
							s_count[1-1] += 1;
						}
						else if (one_num == '2') {
							s_count[2-1] += 1;
						}
						else if (one_num == '3') {
							s_count[3-1] += 1;
						}
						else if (one_num == '4') {
							s_count[4-1] += 1;
						}
						else if (one_num == '5') {
							s_count[5-1] += 1;
						}
						else if (one_num == '6') {
							s_count[6-1] += 1;
						}
						else if (one_num == '7') {
							s_count[7-1] += 1;
						}
						else if (one_num == '8') {
							s_count[8-1] += 1;
						}
						else if (one_num == '9') {
							s_count[9-1] += 1;
						}
					}
						
					else if (ten_num == '1') {
							
							if (one_num == '0') {
								s_count[10-1] += 1;
							}
							else if (one_num == '1') {
								s_count[11-1] += 1;
							}
							else if (one_num == '2') {
								s_count[12-1] += 1;
							}
							else if (one_num == '3') {
								s_count[13-1] += 1;
							}
						}
						
					}
					
					for (int k=0; k<13; k++) {
						if (s_count[k] > 1) {
							error = "ERROR";
							break;
						}
					}
					
				
				
				if (card == 'D') {
					
					
					if (ten_num == '0') {
						
						if (one_num == '1') {
							d_count[1-1] += 1;
						}
						else if (one_num == '2') {
							d_count[2-1] += 1;
						}
						else if (one_num == '3') {
							d_count[3-1] += 1;
						}
						else if (one_num == '4') {
							d_count[4-1] += 1;
						}
						else if (one_num == '5') {
							d_count[5-1] += 1;
						}
						else if (one_num == '6') {
							d_count[6-1] += 1;
						}
						else if (one_num == '7') {
							d_count[7-1] += 1;
						}
						else if (one_num == '8') {
							d_count[8-1] += 1;
						}
						else if (one_num == '9') {
							d_count[9-1] += 1;
						}
					}
					
					else if (ten_num == '1') {
							if (one_num == '0') {
								d_count[10-1] += 1;
							}
							else if (one_num == '1') {
								d_count[11-1] += 1;
							}
							else if (one_num == '2') {
								d_count[12-1] += 1;
							}
							else if (one_num == '3') {
								d_count[13-1] += 1;
							}
						}
						
					}
					
					for (int k=0; k<13; k++) {
						if (d_count[k] > 1) {
							error = "ERROR";
							break;
						}
					}
				
			
				
				
				if (card == 'H') {
					
					
					if (ten_num == '0') {
						
						if (one_num == '1') {
							h_count[1-1] += 1;
						}
						else if (one_num == '2') {
							h_count[2-1] += 1;
						}
						else if (one_num == '3') {
							h_count[3-1] += 1;
						}
						else if (one_num == '4') {
							h_count[4-1] += 1;
						}
						else if (one_num == '5') {
							h_count[5-1] += 1;
						}
						else if (one_num == '6') {
							h_count[6-1] += 1;
						}
						else if (one_num == '7') {
							h_count[7-1] += 1;
						}
						else if (one_num == '8') {
							h_count[8-1] += 1;
						}
						else if (one_num == '9') {
							h_count[9-1] += 1;
						}
						
					}
					
					else if (ten_num == '1') {
							if (one_num == '0') {
								h_count[10-1] += 1;
							}
							else if (one_num == '1') {
								h_count[11-1] += 1;
							}
							else if (one_num == '2') {
								h_count[12-1] += 1;
							}
							else if (one_num == '3') {
								h_count[13-1] += 1;
							}
						}
						
					}
					
					
					for (int k=0; k<13; k++) {
						if (h_count[k] > 1) {
							error = "ERROR";
							break;
						}
					}
					
				
				
				
				
				if (card == 'C') {
					
					
					if (ten_num == '0') {
						
						if (one_num == '1') {
							c_count[1-1] += 1;
						}
						else if (one_num == '2') {
							c_count[2-1] += 1;
						}
						else if (one_num == '3') {
							c_count[3-1] += 1;
						}
						else if (one_num == '4') {
							c_count[4-1] += 1;
						}
						else if (one_num == '5') {
							c_count[5-1] += 1;
						}
						else if (one_num == '6') {
							c_count[6-1] += 1;
						}
						else if (one_num == '7') {
							c_count[7-1] += 1;
						}
						else if (one_num == '8') {
							c_count[8-1] += 1;
						}
						else if (one_num == '9') {
							c_count[9-1] += 1;
						}
					}
					
					else if (ten_num == '1') {
							if (one_num == '0') {
								c_count[10-1] += 1;
							}
							else if (one_num == '1') {
								c_count[11-1] += 1;
							}
							else if (one_num == '2') {
								c_count[12-1] += 1;
							}
							else if (one_num == '3') {
								c_count[13-1] += 1;
							}
						}
						
					}
					
					for (int k=0; k<13; k++) {
						if (c_count[k] > 1) {
							error = "ERROR";
							break;
						}
					}
				
				
				
			}
			
			
			if (error.equals("ERROR")) {
				System.out.println("#" + test_case + " " + error);
			}
			
			else {
				
				int s = 13;
				int d = 13;
				int h = 13;
				int c = 13;
				
				
				
				for (int idx=0; idx<13; idx++) {
					
					s -= s_count[idx];
					d -= d_count[idx];
					h -= h_count[idx];
					c -= c_count[idx];
					
					
					
				}
				System.out.println("#" + test_case + " " + s + " " + d + " " + h +  " " + c);
			}
			
			
			
			
			
			
			
		
	}
}
	
	
}