package baekjoon.b_7562;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] move = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // 0 -> normal
            // 1 -> destination
            // 2 -> visited

            int l = sc.nextInt();

            int s1 = sc.nextInt();
            int t1 = sc.nextInt();
            int s2 = sc.nextInt();
            int t2 = sc.nextInt();

            int[][] map = new int[l][l];

            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    map[j][k] = 0;
                }
            }

            map[s2][t2] = 1;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{s1, t1, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (map[x][y] == 1) {
                    ans.add(cur[2]);
                    break;
                }

                if (map[x][y] != 2) {
                    map[x][y] = 2;

                    for (int k = 0; k < 8; k++) {
                        int newX = x + move[k][0];
                        int newY = y + move[k][1];

                        if (newX >= 0 && newX < l && newY >= 0 && newY < l) {
                            q.add(new int[]{newX, newY, cur[2] + 1});
                        }
                    }

                }

            }

        }

        ans.forEach(System.out::println);

    }
}
