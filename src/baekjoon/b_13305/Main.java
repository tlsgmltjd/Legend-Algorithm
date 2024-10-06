package baekjoon.b_13305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] lens = new long[N - 1];
        long[] prices = new long[N];
        for (int i = 0; i < N - 1; i++)
            lens[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            prices[i] = sc.nextInt();

        long pay = 0;

        for (int i = 0; i < N; i++) {
            if (i >= lens.length) break;
            pay += prices[i] * lens[i];

            int add = 0;
            for (int j = i+1; j < N; j++) {
                if (prices[i] > prices[j] || j >= lens.length) {
                    break;
                } else {
                    // 기름 값이 너무 비싸
                    pay += prices[i] * lens[j];
                    add++;
                }
            }
            i += add;
        }

        System.out.println(pay);
    }
}
