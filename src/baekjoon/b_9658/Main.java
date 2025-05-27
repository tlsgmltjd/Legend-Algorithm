package baekjoon.b_9658;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] dp = new boolean[1000+1];

        dp[2] = true;
        dp[4] = true;

        for (int i = 5; i <= n; i++) {
            dp[i] = !dp[i-1] || !dp[i-3] || !dp[i-4];
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
