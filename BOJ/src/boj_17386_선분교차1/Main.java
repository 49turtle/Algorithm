package boj_17386_선분교차1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        double l1;
        double l2;

        if (x1 == x2) {
            l1 = Double.MAX_VALUE;
        } else {
            l1 = (double) (y2 - y1) / (x2 - x1);
        }

        if (x3 == x4) {
            l2 = Double.MAX_VALUE;
        } else {
            l2 = (double) (y4 - y3) / (x4 - x3);
        }

        if (l1 == l2) {
            System.out.println(0);
            return;
        }

        double k1 = y1 - l1 * x1;
        double k2 = y3 - l2 * x3;

        double x, y;

        if (l1 == Double.MAX_VALUE) {
            x = x1;
            y = l2 * x + k2;
        } else if (l2 == Double.MAX_VALUE) {
            x = x3;
            y = l1 * x + k1;
        } else {
            x = (k2 - k1) / (l1 - l2);
            y = l1 * x + k1;
        }

        int sx1 = Math.min(x1, x2);
        int lx1 = Math.max(x1, x2);
        int sy1 = Math.min(y1, y2);
        int ly1 = Math.max(y1, y2);

        int sx2 = Math.min(x3, x4);
        int lx2 = Math.max(x3, x4);
        int sy2 = Math.min(y3, y4);
        int ly2 = Math.max(y3, y4);

        if (x < sx1 || y < sy1 || x > lx1 || y > ly1 || x < sx2 || y < sy2 || x > lx2 || y > ly2) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}

