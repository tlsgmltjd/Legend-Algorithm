package baekjoon.b_14720;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        List M = new ArrayList();
        int count = 0;
        Integer pre = null;

        for (int i = 0; i < N; i++) {
            M.add(in.nextInt());
        }

        for (int i = 0; i < N; i++) {
            if (pre == null) {
                if (M.get(i).equals(0)) {
                    count++;
                    pre = 0;
                }
            } else {
                if (pre.equals(1) && M.get(i).equals(2)) {
                    count++;
                    pre = 2;
                } else if (pre.equals(2) && M.get(i).equals(0)) {
                    count++;
                    pre = 0;
                } else if (pre.equals(0) && M.get(i).equals(1)) {
                    count++;
                    pre = 1;
                }
            }
        }

        System.out.println(count);

    }
}
