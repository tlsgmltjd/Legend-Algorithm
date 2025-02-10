package baekjoon.b_12865;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] item = new int[n][2];

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            item[i][0] = w;
            item[i][1] = v;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= k; i++) {
                if (item[j][0] > k) {
                    dp[i][j] = dp[j == 0 ? i-1 : i][j == 0 ? j : j - 1];
                } else {
                    if (item[j][0] <= i) {
                        if (j == 0) {
                            if (i == item[j][0]) {
                                dp[i][j] = item[j][1];
                            } else {
                                dp[i][j] = dp[i - 1][j];
                            }
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1], item[j][1] + dp[Math.max(i - item[j][0], 0)][j - 1]);
                        }
                    } else {
                        dp[i][j] = dp[j == 0 ? i - 1 : i][j == 0 ? j : j - 1];
                    }
                }
            }
        }



        int max = -1;
        for (int i = 0; i < n; i++) {
            if (dp[k][i] > max) {
                max = dp[k][i];
            }
        }

        System.out.println(max);

    }
}
