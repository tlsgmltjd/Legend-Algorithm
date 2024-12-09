package baekjoon.b_5567;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] isVisited = new boolean[N+1];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i < M+5; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        AtomicInteger sum = new AtomicInteger();
        List<Integer> start = list.get(1);
        isVisited[1] = true;

        start.forEach(s -> {
            if (!isVisited[s]) {
                sum.getAndIncrement();
            }
                isVisited[s] = true;
//                System.out.println("1 =============== " + s);

                List<Integer> is = list.get(s);
                is.forEach(i -> {
                    if (!isVisited[i]) {
                        isVisited[i] = true;
                        sum.getAndIncrement();
//                        System.out.println("2 =============== " + i);
                    }
                });
        });

        System.out.println(sum.get());

        /**
         * 1: 2, 3
         * 2: 1, 3
         * 3: 1, 4, 2
         * 4: 3, 5
         * 5: 4
         */

        // 2, 3, 4

    }
}
