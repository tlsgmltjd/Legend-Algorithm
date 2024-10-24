package baekjoon.b_11286;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // pq의 Comparator를 구현
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> {
            Integer va = (Integer) a;
            Integer vb = (Integer) b;
            int A = Math.abs(va);
            int B = Math.abs(vb);

            if (A == B) {
                if (va <= vb) {
                    return -1;
                } else {
                    return 1;
                }
            }

            if (A < B) {
                return -1;
            } else {
                return 1;
            }
        });

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();

            if (M == 0) {
                if (pq.isEmpty()) {
                    res.add(0);
                } else {
                    res.add(pq.poll());
                }
            } else {
                pq.add(M);
            }
        }

        for (Integer re : res) {
            System.out.println(re);
        }

    }
}
