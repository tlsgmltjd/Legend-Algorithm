package baekjoon.b_21736;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[][] move = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        map = new char[n][m];
        visited = new boolean[n][m];
        int doX = 0, doY = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                char current = line.charAt(j);

                if (current == 'I') {
                    doX = i;
                    doY = j;
                }

                map[i][j] = current;
            }
        }

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{doX, doY});
        int meet = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll[0];
                int y = poll[1];

                if (x + move[i][0] < n && y + move[i][1] < m && x + move[i][0] >= 0 && y + move[i][1] >= 0 &&
                    !visited[x + move[i][0]][y + move[i][1]]
                ) {
                    if (map[x + move[i][0]][y + move[i][1]] == 'P') {
                        queue.add(new int[]{x + move[i][0], y + move[i][1]});
                        visited[x + move[i][0]][y + move[i][1]] = true;
                        meet++;
                    } else if (map[x + move[i][0]][y + move[i][1]] == 'O') {
                        queue.add(new int[]{x + move[i][0], y + move[i][1]});
                        visited[x + move[i][0]][y + move[i][1]] = true;
                    }
                }
            }
        }

        if (meet == 0) {
            System.out.println("TT");
        } else {
            System.out.println(meet);
        }

    }

}
