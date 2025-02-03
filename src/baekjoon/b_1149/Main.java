package baekjoon.b_1149;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int []> table = new ArrayList<int []>();

        // r: 0, g: 1, b: 2

        int pre = -1;

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            table.add(new int [] {r, g, b});
        }

        for (int i = 0; i < n; i++) {

            int min = 10000;

            if (min > table.get(i)[0] && pre != 0) {
                min = table.get(i)[0];
                pre = 0;
            } else if (min > table.get(i)[1] && pre != 1) {
                min = table.get(i)[1];
                pre = 1;
            } else if (min > table.get(i)[2] && pre != 2) {
                min = table.get(i)[2];
                pre = 2;
            }

        }

    }

}
