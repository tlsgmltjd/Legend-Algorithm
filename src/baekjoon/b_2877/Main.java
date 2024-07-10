package baekjoon.b_2877;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        String s = Integer.toBinaryString(K + 1); // 2 -> 3 -> 11

        for (int i = 1; i < s.length(); i++) {
            System.out.print(s.charAt(i) == '0' ? 4 : 7);
        }

    }
}
