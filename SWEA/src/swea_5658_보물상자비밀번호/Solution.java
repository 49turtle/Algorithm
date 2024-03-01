package swea_5658_보물상자비밀번호;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			sc.nextLine();
			
			char[] numArr = sc.nextLine().toCharArray();
			
			List<Integer> resultList = new ArrayList<Integer>();
			
			int st = N/4;
			char[] rotNumArr = new char[numArr.length];
			
			for(int r=0; r<=st; r++) {
				
				for (int i=0; i<numArr.length; i++) {
					rotNumArr[i] = numArr[(i+1) % N];
				}
				
				
				for (int i=0; i<numArr.length; i+=st) {
					char[] partArr = new char[st];
					
					for (int j=i; j<i+st; j++) {
						partArr[j-i] = rotNumArr[j];
					}
					int result = convertNumber(partArr);
					if (!resultList.contains(result)) {
						resultList.add(result);
					}
				}
				
				for (int i=0; i<numArr.length; i++) {
					numArr[i] = rotNumArr[i];
				}
				
			}
			
			
			
			Collections.sort(resultList);
			
			
			System.out.printf("#%d %d\n", test_case, resultList.get(resultList.size() - K));
			
		}
		
		
		
		
		
		sc.close();
		
			
	}
	
	
	static int convertNumber(char[] cArr) {
		int len = cArr.length;
		
		int result = 0;
		int exp = 0;
		
		for (int i=len-1; i>=0; i--) {
			
			int num = cArr[i];
			if (num < 'A') {
				num -= 48;
			}
			else {
				num -= 55;
			}
			result += num * Math.pow(16, exp++);
		}
		
		return result;
	}

}
