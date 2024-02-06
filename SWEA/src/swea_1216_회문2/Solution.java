package swea_1216_회문2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_1216_회문2/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			sc.nextInt();
			
			
			char[][] arr = new char[100][100];
			
			
			for (int i=0; i<100; i++) {
				arr[i] = sc.next().toCharArray();
			}

			
			
			int max_len = -1;
			
			int check_len = -1;
			
			for (int i=0; i<100; i++) {
				
				
				int len = 1;
				
				while (checkPalindrome(len, arr[i])) {
					len++;
					System.out.println(len);
				}
				
				if (len > max_len) {
					max_len = len;
//					System.out.println(max_len);
				}
				
			}
			
//			System.out.println(max_len);
			
		}
	}
	
	
	
	public static boolean checkPalindrome(int len, char[] arr) {
		
//		System.out.println("len = " + len + ", arr = " + Arrays.toString(arr));
		for (int n=0; n<100-(len-1); n++) {
			int check = 0;
			for (int i=0; i<(len/2); i++) {
				
//				System.out.println("i = " + i);
//				System.out.println("n = " + n);
//				System.out.println(len-1-i);
//				System.out.println("n+i="+(n+i));
//				System.out.println("n+len-i-1="+(n+len-1-i));
				
				
				if (arr[n+i] != arr[n+len-i-1]) {
					check = -1;
				}
			}
			if (check == 0) {
				return true;
			}
			else {return false;}
			
		}
		return false;
	
	}
	
	
	
	
	
	
	
	// 해당 길이를 갖고 있는 회문을 갖고 있는가?
//	public static int checkPalindrome(int len, char[] arr) {
//		for (int i=0; i<len/2; i++) {
//			if (arr[i] != arr[len-1-i]) {
//				return -1;
//			}
//		}
//		return len;
//	}
//	
	
	
	// printArr()
	public static void printArr(char[][] arr) {
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	
	
}