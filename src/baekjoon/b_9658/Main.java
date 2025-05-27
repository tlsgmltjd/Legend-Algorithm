package baekjoon.b_9658;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // SK -> true
        // CY -> false

        boolean[] dp = new boolean[1000+1];

        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;

        if (n < 5) {
            System.out.println(dp[n] ? "SK" : "CY");
            return;
        }

        for (int i = 5; i <= n; i++) {
            if (!dp[i-1] || !dp[i-3] || !dp[i-4]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
