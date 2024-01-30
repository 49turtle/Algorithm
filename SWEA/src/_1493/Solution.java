package _1493;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("src/_1493/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			 int p = sc.nextInt();
			 int q = sc.nextInt();
			 
			 
			 
			 
			
		}
		
		
		
	}
	
	
	public static int[] returnLocation(int p) {
		
		int[] arr = new int[2];
		
		
		int num = 1;
		int x = 1;
		int y = 1;
		
		while (p>0) {
			p -= num;
			num++;
		}
		
		int r = 0 - p;
		
		
		
		
		return arr;
	}
	
}