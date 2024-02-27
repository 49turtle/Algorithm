package swea_5215_햄버거다이어트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// 각 재료별 칼로리 값을 저장할 배열 cal
	static int[] cal;
	// 각 재료별 맛 점수를 저장할 배열 point
	static int[] point;

	// 칼로리 limit값을 메소드에 전달해주기 위해 static으로 선언
	static int limit;

	// 제한된 칼로리 안에서 발생할 수 있는 point 총합 경우의 수들을 담는 리스트 pointList
	static List<Integer> pointList;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 입력
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 재료의 수 N
			int N = sc.nextInt();
			// 제한 칼로리 L
			int L = sc.nextInt();

			// 제한 칼로리를 static 변수에 담아 갱신
			limit = L;

			// 칼로리와 맛 점수를 static으로 갱신하여 입력받기
			cal = new int[N];
			point = new int[N];
			for (int i = 0; i < N; i++) {
				point[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}

			// 아래의 calcCalorie메소드로 계산될 포인트의 총합을 담을 pointList 갱신
			pointList = new ArrayList<Integer>();

			// 0번 인덱스, 칼로리의 총합은 0, 포인트 총합은 0인 상태로 calcCalorie 실행
			// 메소드를 통해 pointList에 값들이 add될 것임
			calcCalorie(0, 0, 0);

			// 나올 수 있는 포인트의 총합 중 가장 큰 포인트의 총합을 찾아 출력
			int answer = -1;
			for (int point : pointList) {
				if (point > answer) {
					answer = point;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}

		sc.close();
	}

	static void calcCalorie(int idx, int calSum, int pointSum) {
		// 주어진 재료를 다 확인한 경우
		// pointList에 add하고, 함수 반환(중지)
		if (idx >= cal.length) {
			pointList.add(pointSum);
			return;
		}

		// 만약 limit보다 아직 작다면, 현재 재료를 선택하고, point를 갱신
		if (calSum + cal[idx] < limit) {
			calcCalorie(idx + 1, calSum + cal[idx], pointSum + point[idx]);
		}

		// 현재 재료를 선택하지 않고, 다음 재료를 탐색
		calcCalorie(idx + 1, calSum, pointSum);

	}

}
