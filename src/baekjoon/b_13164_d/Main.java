package baekjoon.b_13164_d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }

        int div = (p.length + 1) / K;

        int temp = 0;

        int[] mon = new int[K];

        for (int i = 0; i < K; i++) { // 3

            int min = p[temp];
            int max = -1;

            for (int j = 0; j < div; j++) { // 2

                if (temp >= N) {
                    break;
                }

                if (p[temp] > max) {
                    max = p[temp];
                }

                if (p[temp] < min) {
                    min = p[temp];
                }

                temp++;
            }

            mon[i] = max - min;

        }


        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += mon[i];
        }

        System.out.println(sum);


    }
}
