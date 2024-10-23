package baekjoon.b_9461;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        List<Long> res = new ArrayList<>();

        for (int j = 0; j < T; j++) {
            int N = sc.nextInt();

            if (N == 1 || N == 2 || N == 3) {
                res.add(1L);
                continue;
            } else if (N == 4 || N == 5) {
                res.add(2L);
                continue;
            }

            long[] list = new long[N+1];
            list[1] = 1;
            list[2] = 1;
            list[3] = 1;
            list[4] = 2;
            list[5] = 2;

            for (int i = 0; i < N - 5; i++) {
                list[6 + i] = list[1 + i] + list[5 + i];
            }

            res.add(list[N]);

        }

        for (Long re : res) {
            System.out.println(re);
        }
    }
}
