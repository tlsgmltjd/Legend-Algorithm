package baekjoon.b_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] pos = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 100; i++) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];

            int area = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (!visited[j][k] && map[j][k] > i) {
                            visited[j][k] = true;
                            queue.add(new int[]{j, k});

                            while (!queue.isEmpty()) {
                                int[] arr = queue.poll();

                                for (int p = 0; p < 4; p++) {
                                    int x = arr[0] + pos[p][0];
                                    int y = arr[1] + pos[p][1];

                                    if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
                                        continue;
                                    }

                                    if (map[x][y] > i) {
                                        visited[x][y] = true; // 큐에 넣음과 동시에 방문처리
                                        queue.add(new int[]{x, y});
                                    }
                                }
                            }

                            area++;
                        }

                }
            }

            if (area == 0) {
                break;
            }

            max = Math.max(max, area);
        }

        System.out.println(max);

    }
}
