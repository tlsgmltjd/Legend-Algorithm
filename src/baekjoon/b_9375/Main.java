package baekjoon.b_9375;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {

            int N = sc.nextInt();

            Map<String, Integer> m = new HashMap<>();

            for (int i = 0; i < N; i++) {

                String name = sc.next();
                String category = sc.next();

                if (m.containsKey(category)) {
                    m.put(category, m.get(category) + 1);
                } else {
                    m.put(category, 1);
                }

            }

            int res = 1;

            for (int value : m.values()) {
                res *= (value + 1);
            }

            System.out.println(res - 1);
        }
    }
}
