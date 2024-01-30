package swea_1208_flatten;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution{
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		System.setIn(new FileInputStream("src/swea_1208_flatten/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 덤프 횟수 입력받기
			int dump = sc.nextInt();
			
			// 박스 최대 높이를 저장할 변수 maxHeight, 최소 높이를 저장할 변수 minHeight
			int maxHeight = Integer.MIN_VALUE;
			int minHeight = Integer.MAX_VALUE;
			
			// 가로 길이는 항상 100으로 주어지므로 101개의 길이를 가지는 배열 생성
			// 모든 상자의 높이는 1 이상 100 이하이므로 index값과 height를 일치시키기 위해 길이를 101로 생성
			// index값과 height를 일치시켜 각 인덱스에 해당 인덱스만큼의 높이를 지니는 박스의 개수를 저장하는 카운팅 배열 생성
			int[] heightCountArr = new int[101];
			
			// 100개의 입력 동안 반복할 반복문
			for (int i=0; i<100; i++) {
				// 입력받은 정수값을 height로 저장하고, heightCountArr 배열에 1씩 늘려 저장.(같은 높이인 박스를 카운팅) 
				int height = sc.nextInt();
				heightCountArr[height]++;
				// 박스의 최대 높이를 갱신
				if (maxHeight < height) {
					maxHeight = height;
				}
				// 박스의 최소 높이를 갱신
				if (minHeight > height) {
					minHeight = height;
				}	
			}
			
			
			// 덤프 횟수가 0과 같거나 클 때까지 반복
			while (dump>=0) {
				// 더 이상 maxHeight만큼의 박스가 존재하지 않는다면 maxHeight를 감소
				if (heightCountArr[maxHeight] == 0) {
					maxHeight--;
				}
				// 더 이상 minHeight만큼의 박스가 존재하지 않는다면 minHeight를 증가
				if (heightCountArr[minHeight] == 0) {
					minHeight++;
				}
				// 만약 평탄화가 완료(높이차가 0)됐다면 while문 탈출
				if (maxHeight == minHeight) {	
					break;
				}
				// 최대 높이의 박스를 최소 높이의 박스 위로 평탄화를 수행
				heightCountArr[maxHeight]--;
				heightCountArr[maxHeight-1]++;
				heightCountArr[minHeight]--;
				heightCountArr[minHeight+1]++;
				// 덤프 횟수 감소
				dump--;
			}

			// 정답을 출력
			int answer = maxHeight - minHeight;
			System.out.printf("#%d %d\n", test_case, answer);				
		}
	}
}