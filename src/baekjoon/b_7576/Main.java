package baekjoon.b_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] box = new int[n][m];

        int[][] move = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();

        int noEk = 0;
        int ek = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = sc.nextInt();

                if (v == 0) {
                    noEk++;
                } else if (v == 1) {
                    ek++;
                    queue.add(new int[]{i, j});
                }

                box[i][j] = v;
            }
        }

        if (noEk == 0 && ek == 0) {
            System.out.printf("-1");
            return;
        } else if (noEk == 0 && ek > 0) {
            System.out.printf("0");
            return;
        }

        int start = queue.size();
        int next = 0;
        int days = 0;

        while (!queue.isEmpty()) {
            if (start == 0) {
                days++;
                start = next;
                next = 0;
            }

            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (
                        nx < 0 || ny < 0 || nx >= n || ny >= m
                ) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    box[nx][ny] = 1;
                    next++;
                    noEk--;
                }
            }

            start--;
        }

        if (noEk == 0) {
            System.out.println(days);
        } else {
            System.out.println("-1");
        }

    }
}
