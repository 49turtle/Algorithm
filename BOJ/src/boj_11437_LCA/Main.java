package boj_11437_LCA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	static int[][] p;
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	
	    // 노드의 수 입력
	    int n = sc.nextInt();
	    int[][] edges = new int[n - 1][2];
	
	    // 간선 입력
	    for (int i = 0; i < n - 1; i++) {
	        edges[i][0] = sc.nextInt();
	        edges[i][1] = sc.nextInt();
	    }
	
	    // 인접 리스트 생성
	    List<List<Integer>> adjList = new ArrayList<>();
	    for (int i = 0; i <= n; i++) {
	        adjList.add(new ArrayList<>());
	    }
	
	    for (int[] edge : edges) {
	        adjList.get(edge[0]).add(edge[1]);
	        adjList.get(edge[1]).add(edge[0]);
	    }
	
	    int[][] ancestors = new int[n + 1][];
	    boolean[] visited = new boolean[n + 1];
	
	    // 조상 노드 계산
	    // 1번 노드부터 메소드 시작
	    getAncestors(adjList, ancestors, 1, new ArrayList<>(), visited);
	
//	    for (int i = 1; i <= n; i++) {
//	        System.out.print(i + "번 노드: ");
//	        if (ancestors[i] != null) {
//	            for (int anc : ancestors[i]) {
//	                System.out.print(anc + " ");
//	            }
//	        }
//	        System.out.println();
//	    }
	    
	    
	    
	    int M = sc.nextInt();
	    
	    for (int i=0; i<M; i++) {
	    	int node1 = sc.nextInt();
	    	int node2 = sc.nextInt();
	    	
	    	int max = 1;
	    	
	    	for (int j=0; j<ancestors[node1].length; j++) {
	    		for (int k=0; k<ancestors[node2].length; k++) {
	    			if (ancestors[node1][j] == ancestors[node2][k]) {
	    				if (ancestors[node1][j] > max) {
	    					max = ancestors[node1][j];
	    				}
	    			}
	    		}
	    	}
	    	System.out.println(max);
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	
	}

	private static void getAncestors(List<List<Integer>> adjList, int[][] ancestors, int current, List<Integer> currentAncestors, boolean[] visited) {
	    // 방문체크
		visited[current] = true;
		// 현재까지 저장한 조상 리스트 임시 리스트로 저장
	    List<Integer> tempList = new ArrayList<>(currentAncestors);
	    tempList.add(current);
	    
	    // 조상 리스트를 배열로 변환하여 저장
        int[] ancestorArr = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            ancestorArr[i] = tempList.get(i);
        }
        // 기존의 ancestors 배열에 현재 current 노드의 조상 리스트를 갱신 
        ancestors[current] = ancestorArr;
	    
        // 만약 인접 리스트에 내가 아직 방문하지 않은 노드가 존재한다면?
        // getAncestors 메소드 호출
        for (int n : adjList.get(current)) {
            if (!visited[n]) {
                getAncestors(adjList, ancestors, n, tempList, visited);
            }
        }
	    
	}
}