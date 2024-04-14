package prgs_징검다리건너기;

public class Solution_slidingWindow {

	public static void main(String[] args) {
		
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int[] subStones = new int[k];
		
		int max = -987654321;
		
		for (int i=0; i<k; i++) {
			subStones[i] = stones[i];
			max = Math.max(stones[i], max);
		}
		
		int answer = -1;
		
		for (int i=k; i<stones.length; i++) {
			for (int j=0; j<k-1; j++) {
				subStones[j] = subStones[j+1];
			}
			subStones[k-1] = stones[i];
			if (stones[i] > max) {
				max = stones[i];
				continue;
			}
			
			
			
		}
		
	}
}
