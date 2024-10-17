package baekjoon.b_1966;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                q.add(new int[]{sc.nextInt(), j});
            }

            int count = 0;
            List<Integer> res = new ArrayList<>();

            while (true) {

                int[] front = q.poll();
                boolean isMax = true;

                for (int j = 0; j < q.size(); j++) {
                    if (front[0] < q.get(j)[0]) {
                        q.offer(front);

                        for (int a = 0; a < j; a++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    count++;
                    if (front[1] == M) {
                        res.add(count);
                        break;
                    }
                }
            }

            res.forEach(System.out::println);

        }

    }
}
