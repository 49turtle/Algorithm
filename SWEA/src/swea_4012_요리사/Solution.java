package swea_4012_요리사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int[] selArr;
	static int ingNum;
	static List<int[]> caseList;
	static int[][] synergyArr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			// 재료의 개수 N을 static으로 저장
			ingNum = N;

			// N/2개만큼 재료를 선택할 것이므로 N/2 길이를 갖는 selArr static으로 선언
			selArr = new int[N / 2];
			// 각 selArr를 caseList에 담을 것임
			// 즉, 재료를 고를 수 있는 모든 경우를 배열로 생성해 list에 저장할 것임
			caseList = new ArrayList<int[]>();

			// 시너지 맵 입력받기
			synergyArr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					synergyArr[i][j] = sc.nextInt();
				}
			}

			// 재료는 0번부터 N-1번까지 순서대로 담는다.
			int[] ing = new int[N];
			for (int i = 0; i < N; i++) {
				ing[i] = i;
			}

			// selectIng메소드 실행
			// 실행 결과로 caseList에 모든 selArr의 경우가 배열 형태로 담길 것
			selectIng(0, 0, ing);

			// 시너지 차이의 최솟값을 계산하기 위한 기준 min 초기화
			int min = Integer.MAX_VALUE;

			// caseList 안의 N/2개의 재료를 조합한 경우마다 for문 반복
			for (int[] food1 : caseList) {

				// food1에 사용된 재료라면 true로 저장할 boolean 배열 isUsed 선언
				boolean[] isUsed = new boolean[ingNum];
				// food1에 사용됐다면, 재료 번호에 맞게 true로 바꿔주기
				for (int i = 0; i < N / 2; i++) {
					isUsed[food1[i]] = true;
				}
				
				// food1 배열을 calcSynergy에 넣어 음식 1의 시너지를 계산
				int synergyFood1 = calcSynergy(food1);

				// food1의 나머지 재료들을 사용해 만든 food2를 만들기 위해 isUsed 배열이 false인 것을 골라 담음
				int[] food2 = new int[N / 2];
				int fidx = 0;
				for (int i = 0; i < isUsed.length; i++) {
					if (!isUsed[i]) {
						food2[fidx] = i;
						fidx++;
					}
				}
				
				// food2 배열을 calcSynergy에 넣어 음식 2의 시너지를 계산
				int synergyFood2 = calcSynergy(food2);

				// 둘의 시너지 차이의 절댓값을 계산해 min을 갱신하고, 답을 출력
				if (Math.abs(synergyFood1 - synergyFood2) < min) {
					min = Math.abs(synergyFood1 - synergyFood2);
				}

			}
			System.out.printf("#%d %d\n", test_case, min);
		}
		sc.close();
	}

	
	// 재료들의 조합을 계산해 배열을 생성하고, 이를 리스트에 담을 메소드 
	static void selectIng(int idx, int sidx, int[] ing) {

		// 더 이상 넣을 재료가 없다면
		if (idx >= ingNum) {
			return;
		}

		// N/2개의 재료를 모두 선택했다면, selArr를 caseList에 add.
		if (sidx >= ingNum / 2) {
			caseList.add(selArr.clone());
		}

		else {
			// 현재 idx의 재료를 담아 selArr를 생성하고, 다음 idx의 재료를 탐색
			selArr[sidx] = ing[idx];
			selectIng(idx + 1, sidx + 1, ing);
		}
		// 현재 idx의 재료를 담지 않고, 다음 idx의 재료를 탐색
		selectIng(idx + 1, sidx, ing);
	}

	// 주어진 food 재료들을 돌며 synergySum을 계산
	static int calcSynergy(int[] food) {
		int synergySum = 0;

		for (int i = 0; i < food.length - 1; i++) {
			for (int j = i + 1; j < food.length; j++) {
				synergySum += synergyArr[food[i]][food[j]];
				synergySum += synergyArr[food[j]][food[i]];
			}
		}
		return synergySum;

	}

}
