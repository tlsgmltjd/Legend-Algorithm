package baekjoon.b_3036;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        List<String> l = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int p = sc.nextInt();

            if (F % p == 0) {
                l.add((F / p) + "/1");
            } else {
                int temp = F / p;
                int rest = F % p;

                int son = temp * p + rest;
                int mom = p;

                int gcd = gcd(son, mom);
                l.add(son / gcd + "/" + mom / gcd);

            }
        }

        for (String s : l) {
            System.out.println(s);
        }
    }

    static int gcd(int s, int m) {
        int max = Math.max(s, m);
        int min = Math.min(s, m);

        int r = max % min;

        if (r != 0) {
            return gcd(min, r);
        } else {
            return min;
        }
    }
}
