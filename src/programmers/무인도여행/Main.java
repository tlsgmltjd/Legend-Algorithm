package programmers.무인도여행;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] maps) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j) == 'X' ? -1 : (maps[i].charAt(j) - '0');
            }
        }

        int[][] move = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j] == false) {
                    if (map[i][j] != -1) {

                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;

                        int count = 0;

                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            int x = point[0];
                            int y = point[1];
                            count+=map[x][y];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + move[k][0];
                                int ny = y + move[k][1];

                                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny]) {
                                    continue;
                                }

                                if (map[nx][ny] == -1) {
                                    continue;
                                }

                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }

                        pq.add(count);

                    }
                }
            }
        }

        int[] answer = new int[pq.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }

        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
