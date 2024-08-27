package boj_2910_빈도정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		
		Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		List<Integer> numList = new ArrayList<Integer>(); 
		
		List<Integer> tempList = new ArrayList<Integer>();
		
		
		for (int i=0; i<N; i++) {
			int num = sc.nextInt();
			numList.add(num);
			tempList.add(num);
			
			if (!cntMap.containsKey(num)) {
				cntMap.put(num, 1);
			}
			else {
				int cnt = cntMap.get(num);
				cntMap.put(num, cnt+1);
			}
			
		}
		
//		System.out.println(cntMap);
		
		Collections.sort(numList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (cntMap.get(o2) == cntMap.get(o1)) {
					return tempList.indexOf(o2) - tempList.indexOf(o1);
					
				}
				return Integer.compare(cntMap.get(o2), cntMap.get(o1));
			}
		});
		
		for (int i=0; i<numList.size(); i++) {
			System.out.print(numList.get(i) + " ");
		}
		
		
		
		
		
		
		
	}
	
	
	
}
