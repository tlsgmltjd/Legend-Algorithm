package baekjoon.b_11660;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        int[][] gugan = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                gugan[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            int y1 = gugan[i][0];
            int x1 = gugan[i][1];
            int y2 = gugan[i][2];
            int x2 = gugan[i][3];

            System.out.println(
                                        dp[y2][x2]
                                        - dp[y2][x1-1]
                                        - dp[y1-1][x2]
                                        + dp[y1-1][x1-1]
            );
        }

    }
}
