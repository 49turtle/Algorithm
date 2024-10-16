package boj_1541_잃어버린괄호;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String[] strArr = str.split("\\+|-");
        int[] arr = new int[strArr.length];
        for (int i=0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        boolean isMinus = false;

        int idx = 1;
        int sum = arr[0];

        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '-' || str.charAt(i) == '+'){
                if (str.charAt(i) == '-') {
                    isMinus = true;
                }
                if (isMinus){
                    sum -= arr[idx];
                    idx++;
                }
                else{
                    sum += arr[idx];
                    idx++;
                }
            }

        }
        System.out.println(sum);
    }
}
