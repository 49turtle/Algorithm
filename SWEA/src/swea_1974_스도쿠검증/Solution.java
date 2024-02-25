package swea_1974_스도쿠검증;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int[][] sudokuArr = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudokuArr[i][j] = sc.nextInt();
                }
            }

            Set<Integer> numberSet = new HashSet<Integer>();

            int answer = 1;

            // Check rows
            for (int i = 0; i < 9 && answer == 1; i++) {
                for (int j = 0; j < 9; j++) {
                    numberSet.add(sudokuArr[i][j]);
                }
                if (numberSet.size() != 9) {
                    answer = 0;
                    break;
                }
                numberSet.clear();
            }

            // Check columns
            if (answer == 1) {
                for (int j = 0; j < 9 && answer == 1; j++) {
                    for (int i = 0; i < 9; i++) {
                        numberSet.add(sudokuArr[i][j]);
                    }
                    if (numberSet.size() != 9) {
                        answer = 0;
                        break;
                    }
                    numberSet.clear();
                }
            }

            // Check 3x3
            for (int row = 0; row < 9 && answer == 1; row += 3) {
                for (int col = 0; col < 9 && answer == 1; col += 3) {
                    numberSet.clear();
                    for (int i = row; i < row + 3; i++) {
                        for (int j = col; j < col + 3; j++) {
                            numberSet.add(sudokuArr[i][j]);
                        }
                    }
                    if (numberSet.size() != 9) {
                        answer = 0;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }

        sc.close();
    }
}
