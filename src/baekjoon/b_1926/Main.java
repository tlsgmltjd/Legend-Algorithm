package baekjoon.b_1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int [][] paper;
    static int[][] pos = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        int c = 0;
        int max = Integer.MIN_VALUE;

        boolean no = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    no = true;
                    int size = bfs(i, j);
                    if (size > max) {
                        max = size;
                    }
                    c++;
                }
            }
        }

        if (!no) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(c);
            System.out.println(max);
        }
    }

    static int bfs(int i, int j) {
        int count = 0;

        if (paper[i][j] == 1) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j});

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                paper[poll[0]][poll[1]] = 0;
                count++;

                for (int k = 0; k < 4; k++) {
                    int x = poll[0] + pos[k][0];
                    int y = poll[1] + pos[k][1];

                    if (x < 0 || y < 0 || x >= n || y >= m) {
                        continue;
                    }

                    if (paper[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        paper[x][y] = 0;
                    }
                }
            }

        }

        return count;
    }

}
