package baekjoon.b_1904;

import java.util.Scanner;

// dp

        public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();


                int[] dp = new int[N+4];

                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 3;

                for (int i = 4; i <= N; i++) {
                    dp[i] = ((dp[i - 1]) + (dp[i - 2])) % 15746;
                }

                System.out.println(dp[N]);
            }

        }
