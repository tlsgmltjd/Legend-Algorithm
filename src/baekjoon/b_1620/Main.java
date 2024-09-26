package baekjoon.b_1620;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> dogam = new HashMap<>();
        Map<Integer, String> dogam2 = new HashMap<>();
        int D = sc.nextInt();
        int N = sc.nextInt();

        for (int i = 1; i <= D; i++) {
            String s = sc.next();
            dogam.put(s, i);
            dogam2.put(i, s);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            try {
                int num = Integer.parseInt(s);
                res.add(dogam2.get(num));
            } catch (Exception e) {
                res.add(String.valueOf(dogam.get(s)));
            }
        }

        for (String re : res) {
            System.out.println(re);
        }
    }
}
