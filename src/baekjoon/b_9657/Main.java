package baekjoon.b_9657;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            int p = 100000000;

            if (dp[i - 1] % 2 == 0) {
                p = Math.min(p, dp[i - 1]);
            }
            if (dp[i - 3] % 2 == 0) {
                p = Math.min(p, dp[i - 3]);
            }
            if (dp[i - 4] % 2 == 0) {
                p = Math.min(p, dp[i - 4]);
            }

            int v;

            if (p == 100000000) {
                v = Math.min(Math.min(dp[i - 1], dp[i - 3]), dp[i - 4]) + 1;
            } else {
                v = p + 1;
            }

            dp[i] = v;
        }

        System.out.println(dp[n] % 2 == 0 ? "CY" : "SK");


    }
}
