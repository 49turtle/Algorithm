package prgs_징검다리건너기;

public class Solution_binarySearch {

	public static void main(String[] args) {

		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;

		int left = 1;
		int right = 200_000_000;

		// left와 right가 같을 때까지 반복...
		// 왜 등호인가?
		// left가 right보다 커지는 순간을 답으로 출력하고자?!
		while (left <= right) {

			// ex) mid: (3 + 8) / 2 = 5
			// mid + 1인가?
			int mid = (left + right) / 2;
//			System.out.println("mid = " + mid);
			
			// 각 반복은 무엇을 의미하는가?
			// 각 iter는 징검다리를 건너게 할 사람의 수를 mid로 저장해서 징검다리를 건너게 해보는 것
			// stones에서 mid 값을 빼본다는 것은?
			// 0 이하인 값들은 내가 점프해야만 넘어갈 수 있는 징검다리가 될 것
			// 0 이하의 값들이 "연속되는 길이"와 "k값"을 비교하며 이분 탐색 
			
			int jump = 0;
			int maxJump = 0;	// 내가 최대로 점프해야하는 길이

			// 징검다리 배열을 돌며
			for (int i = 0; i < stones.length; i++) {
				// 현재 mid 값을 전부 빼보고, 0 이하라면 jump를 1 증가
				if (stones[i] - mid <= 0) {
					jump++;
				} else {	// 만약 0 초과라면, 점프할 필요 없으므로 jump를 다시 0으로
					jump = 0;
				}
				// 각 돌마다 maxJump값을 갱신
				maxJump = Math.max(maxJump, jump);
			}

			// 최대 점프 길이가 아직 k보다 작다면?
			// 즉, 더 많은 사람들을 보낼 가능성이 있다는 뜻
			if (maxJump < k) {
				left = mid + 1;
			}

			// 최대 점프 길이가 k보다 크거나 같다면?
			// 즉, 사람들을 더 적게 보내야 한다는 것
			else {
				right = mid - 1;
			}

		}

		System.out.println(left);

	}

}
