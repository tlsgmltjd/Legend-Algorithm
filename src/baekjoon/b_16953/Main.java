package baekjoon.b_16953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] { A, 1 });

        while(!queue.isEmpty()) {
            long[] x = queue.poll();

            long x1 = x[0] * 2;
            long x2 = Long.parseLong(String.valueOf(x[0]).concat("1"));

            if (x1 == B || x2 == B) {
                System.out.println(x[1] + 1);
                return;
            }

            if (x1 < B) {
                queue.add(new long[] { x1, x[1] + 1 });
            }

            if (x2 < B) {
                queue.add(new long[] { x2, x[1] + 1 });
            }
        }

        System.out.println("-1");

    }
}
