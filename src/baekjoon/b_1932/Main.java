package baekjoon.b_1932;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = map[0][0];

        if (n > 1) {
            dp[1][0] = dp[0][0] + map[1][0];
            dp[1][1] = dp[0][0] + map[1][1];
        }

        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
            dp[i][i] = dp[i - 1][i-1] + map[i][i];

            for (int j = 1; j < i; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        int max = -1;


        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }

        System.out.println(max);


    }
}
