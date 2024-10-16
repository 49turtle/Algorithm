package boj_11478_서로다른부분문자열의개수;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < str.length(); j++) {
                sb.append(str.charAt(j));

                String subString = sb.toString();

                subStrings.add(subString);
            }
        }
        System.out.println(subStrings.size());
    }
}
