package baekjoon.b_1188;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 2 6
        System.out.println(getGcd(N, M) * ((M / (getGcd(N, M)) - 1)));
    }
    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b);
        }
    }
}
