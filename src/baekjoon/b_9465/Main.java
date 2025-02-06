package baekjoon.b_9465;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    int v = sc.nextInt();
                    arr[j][k] = v;
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (n > 1) {
                dp[0][1] = arr[0][1] + arr[1][0];
                dp[1][1] = arr[1][1] + arr[0][0];
            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = arr[0][j] + Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] = arr[1][j] + Math.max(dp[0][j - 1], dp[0][j - 2]);
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }

    }
}
