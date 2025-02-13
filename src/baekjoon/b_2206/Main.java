package baekjoon.b_2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        int[][] pos = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});

        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], ddul = poll[2], depth = poll[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (nx == n-1 && ny == m-1) {
                    System.out.println(depth+1);
                    return;
                }

                int pd = 0;

                if (map[nx][ny] == 1) {
                    if (ddul == 1) {
                        continue;
                    } else if (ddul == 0) {
                        pd = 1;
                    }
                }

                if (
                        (ddul == 0 && (!visited[nx][ny][0])) ||
                        (ddul == 1 && (!visited[nx][ny][0] && !visited[nx][ny][1]))
                ) {
                    visited[nx][ny][ddul] = true;
                    queue.add(new int[]{nx, ny, ddul + pd, depth + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
