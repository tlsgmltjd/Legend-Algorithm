package baekjoon.b_1890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = map[i][j];
                if (next == 0) {break;}
                if (next + i < n) {
                    dp[i + next][j] += dp[i][j];
                }
                if (next + j < n) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
}
