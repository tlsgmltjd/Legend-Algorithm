package baekjoon.b_2583;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int m;
    static int n;

    static int[][] move = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    static boolean[][] map;

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();

        map = new boolean[m][n];

        for (int i = 0; i < k; i++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int xl = x2 - x1;
            int yl = y2 - y1;
            int y = m - y1 - 1;

            for (int j = 0; j < yl; j++) {
                for (int o = 0; o < xl; o++) {
                    map[y - j][x1 + o] = true;
                }
            }

        }

        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map[i][j]) {
                    ans++;
                    count = 0;
                    dfs(i, j);
                    pq.add(count);
                }
            }
        }

        System.out.println(ans);
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                System.out.print(pq.poll());
            } else {
                System.out.print(pq.poll() + " ");
            }
        }

    }

    static void dfs(int i, int j) {
        if (!map[i][j]) {
            count++;
            map[i][j] = true;
            for (int h = 0; h < 4; h++) {
                if (
                        i + move[h][0] < 0 || j + move[h][1] < 0 ||
                        i + move[h][0] >= m || j + move[h][1] >= n
                ) {
                    continue;
                }

                if (!map[i+move[h][0]][j+move[h][1]]) {
                    dfs(i+move[h][0], j+move[h][1]);
                }
            }
        }
    }

}
