package baekjoon.b_2667;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    // 4방향 탐색
    static int[][] pos = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int size = search(i, j);
                    if (size > 0) {
                        pq.add(size);
                    }
                }
            }
        }

        System.out.println(pq.size());

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

    static int search(int i, int j) {
        int size = 0;

        if (i < 0 || j < 0 || i >= N || j >= N) {
            return 0;
        }

        if (!visited[i][j]) {
            visited[i][j] = true;

            if (map[i][j] == 1) {
                size += search(i + pos[0][0], j + pos[0][1]);
                size += search(i + pos[1][0], j + pos[1][1]);
                size += search(i + pos[2][0], j + pos[2][1]);
                size += search(i + pos[3][0], j + pos[3][1]);

                return size + 1;
            }
        }

        return 0;
    }
}
