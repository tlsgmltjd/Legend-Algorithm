package baekjoon.b_1026;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> A = new PriorityQueue();
        PriorityQueue<Integer> B = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            B.add(sc.nextInt());
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            res += A.poll() * B.poll();
        }

        System.out.println(res);
    }
}
