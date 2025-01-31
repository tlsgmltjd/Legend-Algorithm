package baekjoon.b_1309;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        long[][] dp = new long[n][3];
//        dp[0][0] = 1;
//        dp[0][1] = 1;
//        dp[0][2] = 1;
//
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
//            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
//            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
//        }
//
//        long sum = dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2];
//        System.out.println(sum % 9901);

        // 경우의 수
        // 0: 해당 줄에 아무 것도 배치하지 않는 경우의 수
        // 1: 해당 줄 왼쪽에 배치하는 경우의 수
        // 2: 해당 줄 오른쪽에 배치하는 경우의 수

        // 0 | 1 | 2
        // ---------
        // 1 | 1 | 1
        // 3 | 2 | 2

        int n0 = 1, n1 = 1, n2 = 1;

        for (int i = 1; i < n; i++) {
            int temp0 = n0;
            int temp1 = n1;
            int temp2 = n2;

            n0 = (temp0 + temp1 + temp2) % 9901;
            n1 = (temp0 + temp2) % 9901;
            n2 = (temp0 + temp1) % 9901;
        }

        int sum = n0 + n1 + n2;
        System.out.println(sum % 9901);


    }
}
