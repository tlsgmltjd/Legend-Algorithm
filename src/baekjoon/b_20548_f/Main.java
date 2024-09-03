package baekjoon.b_20548_f;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a = 1;
        int c = 1;
        while (a*7 < N) {
            a *= 7;
            c++;
        }

        int[] temp = new int[c];

        int b = 1;
        for (int i = 0; i < c; i++) {
            if (i == 0) {
                temp[i] = b;
            } else {
                temp[i] = b * 7;
                b *= 7;
            }
        }


        int pre = a;
        int level = (int) Math.pow(3, c);

        if (a == N) {
            System.out.println(a);
            return;
        }

        int temp1 = 0;
        int temp2 = 0;

        while (true) {

            if (pre == N) {
                System.out.println(pre);
                return;
            }

            if (temp1 == 3) {
                temp1 = 1;
                pre = pre + temp[1] - (2 * temp[0]);
                level++;
                temp2++;
            }
            if (temp2 == 2) {
                temp1 = 1;
                temp2 = 1;
                pre = pre + temp[2] - (2 * temp[1]);
                level++;
            }
            pre = pre + temp[0];
            level++;
            temp1++;
        }

    }
}
