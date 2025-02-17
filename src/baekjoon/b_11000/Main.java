package baekjoon.b_11000;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] list = new long[n][2];

        PriorityQueue<Long> res = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();

            list[i] = new long[]{x, y};
        }

        Arrays.sort(list, Comparator.comparingLong(o -> (o)[0]));

        res.add(list[0][1]);

        for (int i = 1; i < n; i++) {
            long x = list[i][0];
            long y = list[i][1];
            long peek = res.peek();

            if (x >= peek) {
                res.poll();
                res.add(y);
            } else {
                res.add(y);
            }
        }

        System.out.println(res.size());

    }
}
