package swea_1989_초심자의회문검사;

import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트케이스의 수 T
		int T = sc.nextInt();
		// 줄을 바꿔 문자열을 받기 위해(개행 문자? 입력받기)
		sc.nextLine();
		
		for (int test_case=1; test_case<=T; test_case++) {
			// 단어를 String으로 입력받고, 이를 toCharArray메소드로 char형의 배열로 쪼
			char[] charArr = sc.nextLine().toCharArray();
			
			// 사용자 정의 메소드인 isPalindrome에 charArr를 대입해 해당 결과에 따라 결과를 나눠 출력
			System.out.printf("#%d ", test_case);
			if (isPalindrome(charArr)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		sc.close();
	}
	
	
	// 파라미터로 입력받은 char형의 배열이 회문인지를 검사하는 메소드 isPalindrome
	public static boolean isPalindrome(char[] charArr) {
		// 배열을 앞에서부터 (배열의 길이)/2-(배열의 길이%2)까지 i를 1씩 증가하며 순회
		// 배열의 길이가 홀수라면 (배열의 길이%2)==1이고, 짝수라면 0이므로
		// 배열의 길이가 홀수인 경우와 짝수인 경우에 맞게 검사하도록 
		for (int i=0; i<=charArr.length/2 - charArr.length%2; i++) {
			// 올바른 방향으로 읽었을 때 읽히는 문자와 거꾸로 읽었을 때 읽히는 문자가 다르다면 false를 출력
			if (charArr[i] != charArr[charArr.length-1-i]) {
				return false;
			}
		}
		return true;
	}
	
}