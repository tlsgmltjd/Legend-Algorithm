package baekjoon.b_16948;

import java.util.*;

public class Main {

    static int n;

    static boolean[][] map;
    static boolean[][] visited;

    static int[][] moveMap = {
            {-2, -1},
            {-2, 1},
            {0, -2},
            {0, 2},
            {2, -1},
            {2, 1}
    };

    // bfs는 큐를 써서 풀자..
    static Queue<List<Integer>> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new boolean[n][n];
        visited = new boolean[n][n];

        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        // 출발지
        visited[r1][c1] = true;

        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        // 목적지
        map[r2][c2] = true;

        if (map[r1][c1]) {
            System.out.println(0);
            return;
        }

        // X, Y, depth
        queue.add(Arrays.asList(r1, c1, 0));

        while (!queue.isEmpty()) {

            List<Integer> target = queue.poll();

            int r = target.get(0);
            int c = target.get(1);
            int d = target.get(2);

            for (int i = 0; i < 6; i++) {
                if (
                        (r + moveMap[i][0]) >= n || (r + moveMap[i][0]) < 0 ||
                        (c + moveMap[i][1]) >= n || (c + moveMap[i][1]) < 0
                ) {
                    continue;
                } else {
                    if (!visited[r+moveMap[i][0]][c+moveMap[i][1]]) {
                        visited[r+moveMap[i][0]][c+moveMap[i][1]] = true;

                        if (map[r+moveMap[i][0]][c+moveMap[i][1]]) {
                            System.out.println(d + 1);
                            return;
                        }

                        for (int j = 0; j < 6; j++) {
                            queue.add(Arrays.asList(r+moveMap[i][0], c+moveMap[i][1], d + 1));
                        }
                    }
                }
            }

        }


        System.out.println(-1);

    }

}
