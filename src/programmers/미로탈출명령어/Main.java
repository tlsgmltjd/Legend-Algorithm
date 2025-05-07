package programmers.미로탈출명령어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String answer = solution(2, 2, 1, 1, 2, 2, 2);
        System.out.println(answer);
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        int[][] move = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        boolean[][] map = new boolean[n][m];
        map[r - 1][c - 1] = true;

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{String.valueOf(x - 1), String.valueOf(y - 1), "", "false"});

        for (int i = 0; i < k; i++) {

            Queue<String[]> queue2 = new LinkedList<>();

            while (!queue.isEmpty()) {
                String[] poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    if (Integer.parseInt(poll[0]) + move[j][0] < 0 || Integer.parseInt(poll[1]) + move[j][1] < 0 ||
                        Integer.parseInt(poll[0]) + move[j][0] >= n || Integer.parseInt(poll[1]) + move[j][1] >= m
                    ) {
                        continue;
                    }

                    queue2.add(new String[]{
                        String.valueOf(Integer.parseInt(poll[0]) + move[j][0]),
                        String.valueOf(Integer.parseInt(poll[1]) + move[j][1]),
                        poll[2] + toSign(j),
                        map[Integer.parseInt(poll[0]) + move[j][0]][Integer.parseInt(poll[1]) + move[j][1]] ? "true" : "false"
                    });
                }
            }

            queue = queue2;

        }

        SortedSet<String> sortedSet = new TreeSet<>();

        for (String[] strings : queue) {
            if (strings[3] != "true") continue;

            sortedSet.add(strings[2]);
        }

        return sortedSet.isEmpty() ? "impossible" : sortedSet.first();
    }

    private static String toSign(int move) {
        return switch (move) {
            case 0 -> "r";
            case 1 -> "d";
            case 2 -> "l";
            case 3 -> "u";
            default -> "";
        };
    }
}
