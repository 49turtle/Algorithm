//package swea_2112_보호필름;
//
//import java.util.Scanner;
//
//public class Solution {
//
//	static int D;
//	static int W;
//	static int K;
//
//	static int[][] film;
//
//	static int answer;
//	
//	static int[] sel;
//	static int[] zeroOneArr;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int T = sc.nextInt();
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//
//			D = sc.nextInt();
//			W = sc.nextInt();
//			K = sc.nextInt();
//
//			film = new int[D][W];
//
//			for (int d = 0; d < D; d++) {
//				for (int w = 0; w < W; w++) {
//					film[d][w] = sc.nextInt();
//				}
//			}
//
//			answer = 0;
//
//			// 1. 검사하기
//			if(check()) {
//				System.out.println(answer);
//			}
//			else {
//				while(check()) {
//					// 내가 바꾸고자 하는 행 개수
//					int k = 1;
//					
//					sel = new int[k];
//					zeroOneArr = new int[k];
//					int[][] copyFilm = copyFilm();
//					
//					
//					
//				}
//				
//				
//				// k는 1부터 K까지
//				int k = 1;
//				sel = new int[k];
//				
//				// 2. 행 선택하기
//				int[] row = chooseRow(0, 0, k);
//				
//				
//				
//				
//			}
//
//
//			// 3. 약품 투여
//
//			// 4. 검사하기
//
//			// 5. 2번으로 돌아가서 행 선택 개수 증가
//
//		}
//
//	}
//
//	private static void chooseZeroOrOne(int k) {
//		for (int i=0; i<k; i++) {
//			zeroOneArr[i]
//		}
//	}
//	
//	private static int[][] copyFilm() {
//		int[][] copyFilm = new int[film.length][film[0].length];
//		for (int i=0; i<film.length; i++) {
//			for (int j=0; j<film[i].length; j++) {
//				copyFilm[i][j] = film[i][j];
//			}
//		}
//		return copyFilm;
//	}
//
//	private static void chooseRow(int sidx, int idx, int k) {
//		
//		if (sidx == k) {
//			
//			doChange(k);
//			return;
//		}
//		
//		if (idx >= D) {
//			return;
//		}
//			
//		chooseRow(sidx, idx+1, k);
//		sel[sidx] = idx;
//		chooseRow(sidx+1, idx+1, k);
//		
//	}
//
//	private static void doChange(int k) {
//		
//		for (int i=0; i<k; i++) {
//			sel[i] = 0;
//		}
//		
//	}
//
//	private static boolean check() {
//
//		boolean isPass = false;
//
//		for (int c = 0; c < W; c++) {
//			int cnt = 1;
//			for (int r = 1; r < D; r++) {
//				if (film[r - 1][c] == film[r][c]) {
//					cnt++;
//					if (cnt == 3) {
//						isPass = true;
//						break;
//					} else {
//						isPass = false;
//					}
//				}
//				else {
//					cnt = 1;
//				}
//			}
//			if (!isPass) {
//				return false;
//			}
//		}
//		return isPass;
//
//	}
//}
