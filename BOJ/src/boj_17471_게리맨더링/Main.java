package boj_17471_게리맨더링;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] cityGraph;

	static List<Integer> result;
	static List<List<Integer>> resultList;

	static int[] areaA;
	static int[] areaB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		cityGraph = new int[N][N];

		int[] population = new int[N];

		for (int i = 0; i < N; i++) {
			population[i] = sc.nextInt();
		}

		int answer = -1;
		boolean canDevide = false;

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num != 0) {
				canDevide = true;
			}
			for (int n = 0; n < num; n++) {
				int city = sc.nextInt() - 1;
				cityGraph[i][city] = 1;
			}
		}

		if (canDevide) {
			result = new ArrayList<Integer>();
			resultList = new ArrayList<List<Integer>>();

			selectArea(0, result);
			
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < resultList.size(); i++) {
				devideTwoArea(resultList.get(i));
				
				boolean flag = true;
				
				for (int a=1; a<areaA.length; a++) {
					if (!isConnected(areaA[0], areaA[a])) {
						flag = false;
					}
				}
				
				for (int b=1; b<areaB.length; b++) {
					if (!isConnected(areaB[0], areaB[b])) {
						flag = false;
					}
				}
				
				
				if (flag) {
					int aSum = 0;
					int bSum = 0;

					for (int a = 0; a < areaA.length; a++) {
						aSum += population[areaA[a]];
					}
					for (int b = 0; b < areaB.length; b++) {
						bSum += population[areaB[b]];
					}

					if (Math.abs(aSum - bSum) < min) {
						min = Math.abs(aSum - bSum);
					}

//					System.out.println(Arrays.toString(areaA));
//					System.out.println("aSum=" + aSum + ", bSum=" + bSum);
				}
				
			}

			if (min != Integer.MAX_VALUE) {
				answer = min;
			}
		}

		System.out.println(answer);

		sc.close();
	}

	static boolean isConnected(int start, int end) {
	    boolean[] visited = new boolean[N];
	    return dfs(start, end, visited);
	}

	static boolean dfs(int current, int end, boolean[] visited) {
	    visited[current] = true;
	    if (current == end) return true;

	    for (int next = 0; next < N; next++) {
	        if (cityGraph[current][next] != 0 && !visited[next]) {
	            if (dfs(next, end, visited)) return true;
	        }
	    }
	    return false;
	}


	static void selectArea(int idx, List<Integer> area) {
	    if (idx == N) {
	        List<Integer> otherArea = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            if (!area.contains(i)) {
	                otherArea.add(i);
	            }
	        }
	        if (!area.isEmpty() && !otherArea.isEmpty()) {
	            resultList.add(new ArrayList<>(area)); 
	        }
	        return;
	    }

	    area.add(idx);
	    selectArea(idx + 1, area);
	    area.remove(area.size() - 1); 

	    selectArea(idx + 1, area);
	}

	

	static void devideTwoArea(List<Integer> cities) {

		areaA = new int[cities.size()];
		areaB = new int[N - cities.size()];

		int idxA = 0;
		int idxB = 0;

		for (int i = 0; i < N; i++) {
			if (cities.contains(i)) {
				areaA[idxA++] = i;
			} else {
				areaB[idxB++] = i;
			}
		}

	}

}
