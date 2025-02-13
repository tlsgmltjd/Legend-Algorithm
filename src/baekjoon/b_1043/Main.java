package baekjoon.b_1043;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] people = new boolean[n + 1];
        int t = sc.nextInt();
        int[] tl = new int[t];
        List<List<Integer>> pl = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int v = sc.nextInt();
            tl[i] = v;
            people[v] = true;
        }

        for (int i = 0; i < m; i++) {
            pl.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            for (int j = 0; j < v; j++) {
                int v2 = sc.nextInt();
                pl.get(i).add(v2);
            }
        }

        for (List<Integer> integers : pl) {
            pl.forEach(info -> info.forEach(i -> {
                if (people[i]) {
                    info.forEach(j -> people[j] = true);
                }
            }));
        }

        AtomicInteger sum = new AtomicInteger();
        AtomicBoolean flag = new AtomicBoolean(false);
        pl.forEach(info -> {
            flag.set(false);
            info.forEach(i -> {
                if (people[i]) {
                    flag.set(true);
                }
            });

            if (!flag.get()) {
                sum.getAndIncrement();
            }
        });

        System.out.println(sum.get());

    }
}
