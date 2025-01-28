package baekjoon.b_1058;

import java.util.Scanner;

public class Main {

    static boolean[][] map;
    static boolean[] v;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new boolean[n][n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) == 'Y';
            }
        }

        long max = -1;

        for (int i = 0; i < n; i++) {

            v = new boolean[n];

            loop(i, 1);

            int m = 0;
            for (int j = 0; j < n; j++) {
                m += v[j] ? 1 : 0;
            }

            max = Math.max(max, (m - 1));

        }

        System.out.println(max);


    }

    static void loop(int i, int depth) {

        v[i] = true;

        for (int j = 0; j < n; j++) {
            if (map[i][j]) {
                v[j] = true;
                if (depth < 2) {
                    loop(j, depth + 1);
                }
            }
        }
    }

}
