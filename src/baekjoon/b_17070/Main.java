package baekjoon.b_17070;

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

        // 0: 가로 -> 오른쪽 한칸, 오른쪽 아래 한칸
        // 1: 세로 -> 아래 한칸, 오른쪽 아래 한칸
        // 2: 대각선 -> 오른쪽 한칸, 아래 한칸, 오른쪽 아래 한칸

        int[][][] dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 0;
                }
            }
        }

        dp[0][0][0] = 1;
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] != 0) {
                        switch (k) {
                            case 0: {
                                if (j + 1 < n && map[i][j + 1] != 1) {
                                    dp[i][j + 1][0] += dp[i][j][k];
                                }
                                if (j + 1 < n && i + 1 < n && map[i+1][j+1] != 1 && map[i][j + 1] != 1 && map[i + 1][j] != 1) {
                                    dp[i + 1][j + 1][2] += dp[i][j][k];
                                }
                                break;
                            }
                            case 1: {
                                if (i + 1 < n && map[i+1][j] != 1) {
                                    dp[i + 1][j][1] += dp[i][j][k];
                                }
                                if (j + 1 < n && i + 1 < n && map[i+1][j+1] != 1 && map[i][j + 1] != 1 && map[i + 1][j] != 1) {
                                    dp[i + 1][j + 1][2] += dp[i][j][k];
                                }
                                break;
                            }
                            case 2: {
                                if (j + 1 < n && map[i][j+1] != 1) {
                                    dp[i][j + 1][0] += dp[i][j][k];
                                }
                                if (i + 1 < n && map[i+1][j] != 1) {
                                    dp[i + 1][j][1] += dp[i][j][k];
                                }
                                if (j + 1 < n && i + 1 < n && map[i+1][j+1] != 1 && map[i][j + 1] != 1 && map[i + 1][j] != 1) {
                                    dp[i + 1][j + 1][2] += dp[i][j][k];
                                }
                                break;
                            }
                        }
                    }
                }

            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);

    }
}
