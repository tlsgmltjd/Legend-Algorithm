package baekjoon.b_2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n+2];
        int[] dp = new int[n+2];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            w[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(w[1]);
            return;
        }

        if (n == 2) {
            System.out.println(w[1] + w[2]);
            return;
        }

        dp[1] = w[1];
        dp[2] = w[1] + w[2];
        dp[3] = Math.max(dp[2], Math.max(dp[1] + w[3], (w[2] + w[3])));

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + w[i], (dp[i-3] + w[i-1] + w[i])));
        }

        System.out.println(dp[n]);
    }
}
