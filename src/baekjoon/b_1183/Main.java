package baekjoon.b_1183;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            arr[i] = A - B;
        }

        Arrays.sort(arr);

        if (N % 2 != 0) {
            System.out.println(1);
        } else {
            System.out.println(Math.abs(arr[(N/2)] - arr[N/2-1]) + 1);
        }

    }
}
