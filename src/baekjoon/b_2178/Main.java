package baekjoon.b_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] pos = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int start = queue.size();
        int count = 0;

        while (!queue.isEmpty()) {

            if (--start == 0) {
                count++;
                start = queue.size();
            }

            int[] poll = queue.poll();
            map[poll[0]][poll[1]] = 0;

            if (poll[1] == M - 1 && poll[0] == N - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + pos[i][0];
                int y = poll[1] + pos[i][1];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (map[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        map[x][y] = 0;
                    }
                }
            }

        }

        System.out.println(count);

    }

}
