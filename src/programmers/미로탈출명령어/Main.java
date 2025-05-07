package programmers.미로탈출명령어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String answer = solution(3, 4, 2, 3, 3, 1, 5);
        System.out.println(answer);
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[][] move = new int[][]{
                {1, 0}, {0, -1}, {0, 1}, {-1, 0}
        };

        int distant = Math.abs(x - r) + Math.abs(y - c);
        if (distant > k || (k - distant) % 2 != 0) {
            return "impossible";
        }

        boolean[][] map = new boolean[n][m];
        map[r - 1][c - 1] = true;

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{String.valueOf(x - 1), String.valueOf(y - 1), ""});

        for (int i = 0; i < k; i++) {

            Queue<String[]> queue2 = new LinkedList<>();
            boolean[][] v = new boolean[n][m];
            String[][] vs = new String[n][m];

            while (!queue.isEmpty()) {
                String[] poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = Integer.parseInt(poll[0]) + move[j][0];
                    int ny = Integer.parseInt(poll[1]) + move[j][1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }

                    if (map[nx][ny] && i == k - 1) {
                        return poll[2] + toSign(j);
                    }

                    if (v[nx][ny]) {
                        if (Integer.parseInt(vs[nx][ny]) <= j) {
                            continue;
                        }
                    }

                    v[nx][ny] = true;
                    vs[nx][ny] = String.valueOf(j);

                    queue2.add(new String[]{
                        String.valueOf(nx),
                        String.valueOf(ny),
                        poll[2] + toSign(j),
                    });
                }
            }

            queue = queue2;

        }

        return "impossible";
    }

    private static String toSign(int move) {
        return switch (move) {
            case 0 -> "d";
            case 1 -> "l";
            case 2 -> "r";
            case 3 -> "u";
            default -> "";
        };
    }
}
