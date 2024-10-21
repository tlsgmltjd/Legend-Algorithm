package baekjoon.b_1003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();

            if (N == 0) {
                res.add("1 0");
                continue;
            } else if (N == 1) {
                res.add("0 1");
                continue;
            }

            int[][] dp = new int[N + 1][2];

            // 0개수, 1개수

            dp[0][0] = 1;
            dp[0][1] = 0;

            dp[1][0] = 0;
            dp[1][1] = 1;


            for (int j = 2; j <= N; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            res.add(dp[N][0] + " " + dp[N][1]);

        }

        for (String re : res) {
            System.out.println(re);
        }

    }
}
