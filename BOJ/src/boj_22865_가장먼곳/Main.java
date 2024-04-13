package boj_22865_가장먼곳;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node{
		
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N;
	static int A;
	static int B;
	static int C;
	
	static List<Node>[] adjList;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		
		int M = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			
			int st = sc.nextInt();
			
			int ed = sc.nextInt();
			int w = sc.nextInt();
			
			adjList[st].add(new Node(ed, w));
			adjList[ed].add(new Node(st, w));
		}
		
		
		
		int[] distA = dijkstra(A);
		int[] distB = dijkstra(B);
		int[] distC = dijkstra(C);
		
		
		int maxMin = Integer.MIN_VALUE;
		int maxIdx = -1;
		
		for (int i=1; i<N+1; i++) {
			if (i == A || i == B || i == C) {
				continue;
			}
			int min = Math.min(Math.min(distA[i], distB[i]), distC[i]);
			if (min > maxMin) {
				maxMin = min;
				maxIdx = i;
			}
		}
		
		System.out.println(maxIdx);
		
	}
	
	public static int[] dijkstra(int start) {
	    int[] dist = new int[N+1];
	    boolean[] visited = new boolean[N+1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[start] = 0;

	    PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.w, node2.w));
	    pq.add(new Node(start, 0));

	    while (!pq.isEmpty()) {
	        Node current = pq.poll();
	        int currentNode = current.v;

	        if (visited[currentNode]) continue;
	        visited[currentNode] = true;

	        for (Node neighbor : adjList[currentNode]) {
	            if (!visited[neighbor.v] && dist[currentNode] + neighbor.w < dist[neighbor.v]) {
	                dist[neighbor.v] = dist[currentNode] + neighbor.w;
	                pq.add(new Node(neighbor.v, dist[neighbor.v]));
	            }
	        }
	    }

	    return dist;
	}
	
	
	
}
