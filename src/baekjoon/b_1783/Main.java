package baekjoon.b_1783;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(Math.min((M + 1) / 2, 4));
        } else if (N >= 3 && M < 7) {
            System.out.println(Math.min(M, 4));
        } else {
            System.out.println(M - 2);
        }


    }
}
