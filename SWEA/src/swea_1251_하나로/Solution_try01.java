package swea_1251_하나로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_try01 {
	
	static int[] p;
	
	
	static int[] cx;
	static int[] cy;
	
	static double E;
	
	static int[] coor;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			

			cx = new int[N];
			cy = new int[N];
			
			
			
			for (int i=0; i<N; i++) {
				cx[i] = sc.nextInt();
			}
			
			for (int i=0; i<N; i++) {
				cy[i] = sc.nextInt();
			}
			
			E = sc.nextDouble();
			
			double[][] networkArr = new double[N][N];
			
			
			
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (i < j) {
						networkArr[i][j] = getCost(i, j);
					}
				}
			}

			
			p = new int[N];
			
			double answer = 0;
			
			int cnt = 0;
			
			while (cnt < N*(N-1)/2) {
				
				cnt++;
				
				double min = findMin(networkArr);
				
				int A = coor[0];
				int B = coor[1];
				
				int pA = findSet(A);
				int pB = findSet(B);
				
				if (pA != pB) {
					union(pA, pB);
					answer += min;
				}
				
			}
			
			
			System.out.println(answer);
			
			
			
			
			
		}
		
		
		
		
	}
	
	
	static int findSet(int A) {
		if (A != p[A]) {
			p[A] = findSet(A);
		}
		return p[A];
	}
	
	
	static void union(int A, int B) {
		p[B] = A;
	}
	
	
	static double findMin(double[][] map) {
		
		double min = Double.MAX_VALUE;
		
		coor = new int[2];
		
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (map[i][j] > 0 && map[i][j] < min) {
					min = map[i][j];
					coor[0] = i;
					coor[1] = j;
				}
			}
		}
		
		map[coor[0]][coor[1]] = 0;
		
		
		return min;
	}
	
	
	static double getCost(int i, int j) {
		double L = (cx[i] - cx[j]) * (cx[i] - cx[j]) + (cy[i] - cy[j]) * (cy[i] - cy[j]) ;
		
		return  L*E;
	}
	
}
