package baekjoon.b_2839;

import java.util.Scanner;

// 설탕 배달
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int count = 0;

        while (N >= 0) {

            if(N % 5 == 0) {
                System.out.println(count + N / 5);
                return;
            }
            N-=3;
            count++;

        }

        System.out.println(-1);
    }
}