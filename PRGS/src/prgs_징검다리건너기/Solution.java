package prgs_징검다리건너기;

public class Solution {

	public static void main(String[] args) {
		
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		
//		int[] stones = {9, 6, 5, 4, 7, 8, 5, 7, 7, 2, 9};
//		int k = 3;
		
//		int[] stones = {3, 4, 5, 6, 6, 6};
//		int k = 2;
		

        int answer = 987654321;
        
        for (int i=0; i<stones.length-k+1; i++){
            int num = stones[i];
            int max = -987654321;
            if (num < answer) {
            	for (int j=0; j<k; j++){
            		max = Math.max(max, stones[i+j]);
        		}
            	answer = Math.min(max, answer);
            }
            
        }
        
        System.out.println(answer);
		
	}
}
