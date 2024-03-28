package swea_1238_Contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	
	static List<Integer> numList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			int st = sc.nextInt();
			
			List<Integer>[] adjList = new ArrayList[101];
			
			for (int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if (adjList[from] == null) {
					adjList[from] = new ArrayList<>();
				}
				adjList[from].add(to);
			}
			
			
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			
			boolean[] visited = new boolean[101];
			
			queue.add(st);
			
			int maxNum = 0;
			
			while(!queue.isEmpty()) {
				
				int size = 0;
				System.out.println(queue.size());
				
				while (size < queue.size()) {
					
					size++;
					
					int from = queue.poll();
					
					
					if (visited[from] || adjList[from] == null) {
						continue;
					}
					
					visited[from] = true;
					
					List<Integer> list = new ArrayList<Integer>();
					
					for (int i=0; i<adjList[from].size(); i++) {
						
						int num = adjList[from].get(i);
						queue.add(num);
						list.add(num);
						
					}
					
				}
				
				
			}
			
			System.out.println("#" + test_case + " " + maxNum);
			
			
			
			
		}
		
		
	}
	
	
	
	
	
}
