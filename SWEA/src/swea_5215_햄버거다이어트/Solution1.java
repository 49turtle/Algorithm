package swea_5215_햄버거다이어트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

	static int[] menuCal;
	static int[] menuPoint;
	static List<Integer> pickedMenu;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			 
			
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			menuCal = new int[N];
			menuPoint = new int[N];
			
			for (int i=0; i<N; i++) {
				menuCal[i] = sc.nextInt();
				menuPoint[i] = sc.nextInt();
			}
			
			pickedMenu = new ArrayList<Integer>();
			
			int answer = 0;
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		
		
		sc.close();
	}
	
	static int pickMenu(int idx, int L, int answer) {
		
		
		if (idx >= menuCal.length) {
			return answer;
		}
		
		
		
		int calorieSum = getCalorieSum(pickedMenu);
		
		
		pickMenu(idx+1, L, answer);
		
		
		if (calorieSum + menuCal[idx] <= L) {
			
			pickedMenu.add(menuCal[idx]);
			answer += menuPoint[idx];
			pickMenu(idx+1, L, answer);
		}
		
		
		
		return answer;
		
	}
	
	
	static int getCalorieSum(List<Integer> list) {
		int answer = 0;
		for (int i=0; i<list.size(); i++) {
			answer += list.get(i);
		}
		return answer;
	}
	
	
}
