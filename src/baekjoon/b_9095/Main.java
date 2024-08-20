package baekjoon.b_9095;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();

            if (N == 0) {
                res.add(0);
                continue;
            } else if (N == 1) {
                res.add(1);
                continue;
            } else if (N == 2) {
                res.add(2);
                continue;
            }

            int[] dp = new int[N + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            res.add(dp[N]);
        }

        for (Integer re : res) {
            System.out.println(re);
        }

    }
}
