package _4789;


// 입력받기가 젤 어려웠음,,
// 1시간 10분동안 입력 문제 해결하느라ㅠ
// Solution"1"이라고 제출해서 런타임 에러ㅠ

// 설계 10분 + 구현 1시간 25분

import java.io.FileInputStream;
import java.util.Scanner;

class Solution1 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/_4789/sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		// nextInt() 다음에 nextLine()을 바로 사용할 경우 남은 개행문자 때문에 문제가 발생
        // 이를 방지하기 위해 nextLine()을 한 번 더 호출!
        sc.nextLine();
        
		for (int test_case = 1; test_case <= T; test_case++) {

			

			// 문자열 입력 받기
            String temp = sc.nextLine();
            

            // 문자열을 숫자 배열로 변환하는 코드
            int[] arr = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
            	// 메소드 확인...
                arr[i] = Character.getNumericValue(temp.charAt(i));
            }

            // 배열 내용 출력하기
//            System.out.println(java.util.Arrays.toString(arr));
            
            
            int sum = 0;
            int answer = 0;
            
            for (int i=0; i<arr.length; i++) {
            	if (sum < i) {
            		answer += i - sum;
            		sum = i + arr[i];
            	}
            	else{
            		sum += arr[i];
            	}
            }
            
            System.out.println("#" + test_case + " " + answer);
            
            
        }
		
    }
}