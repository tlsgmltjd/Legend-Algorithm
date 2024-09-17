package baekjoon.b_1764;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> s = new HashSet<>();

        for (int i = 0; i < N; i++) {
            s.add(sc.next());
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String v = sc.next();
            if (!s.add(v)) {
                res.add(v);
            }
        }

        Collections.sort(res);

        System.out.println(res.size());
        for (String re : res) {
            System.out.println(re);
        }

    }
}
