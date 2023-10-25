package baekjoon.b_1094;

import java.util.Scanner;

// 막대기
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int X = in.nextInt();
        int max = 64;
        int count = 0;

        while (X > 0) {

            if (X - max >= 0) {

                X -= max;
                count++;

            } else {
                max = max / 2;
            }

        }

        System.out.println(count);
    }
}