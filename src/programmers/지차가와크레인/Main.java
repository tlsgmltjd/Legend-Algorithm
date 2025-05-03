package programmers.지차가와크레인;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int answer = solution(new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"}, new String[]{"C", "B", "B", "B", "B", "H"});
        System.out.println(answer);
    }


    public static int solution(String[] storage, String[] requests) {

        int[][] move = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int n = storage[0].length();
        int m = storage.length;

        int answer = n*m;

        String[][] map = new String[m+2][n+2];

        for (int i = 0; i < m+2; i++) {
            for (int j = 0; j < n+2; j++) {
                map[i][j] = "!";
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i+1][j+1] = storage[i].charAt(j) + "";
            }
        }

        for (int r = 0; r < requests.length; r++) {
            String request = requests[r];

            if (request.length() == 1) {

                Queue<int []> queue = new LinkedList<>();
                queue.add(new int[]{0, 0});
                boolean[][] visited = new boolean[m+2][n+2];
                visited[0][0] = true;

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();

                    for (int k = 0; k < move.length; k++) {

                        if (
                            point[0] + move[k][0] < 0 || point[0] + move[k][0] >= m+2 ||
                            point[1] + move[k][1] < 0 || point[1] + move[k][1] >= n+2
                        ) {
                            continue;
                        }

                        if (visited[point[0] + move[k][0]][point[1] + move[k][1]]) {
                            continue;
                        }

                        if (
                            Objects.equals(map[point[0] + move[k][0]][point[1] + move[k][1]], "!")
                        ) {
                            visited[point[0] + move[k][0]][point[1] + move[k][1]] = true;
                            queue.add(new int[]{point[0] + move[k][0], point[1] + move[k][1]});
                        } else if (Objects.equals(map[point[0] + move[k][0]][point[1] + move[k][1]], request)) {
                            map[point[0] + move[k][0]][point[1] + move[k][1]] = "!";
                            visited[point[0] + move[k][0]][point[1] + move[k][1]] = true;
                            answer--;
                        }
                    }

                }


            } else {

                for (int i = 1; i < m+1; i++) {
                    for (int j = 1; j < n+1; j++) {
                        if (Objects.equals(map[i][j], request.charAt(0) + "")) {
                            map[i][j] = "!";
                            answer--;
                        }
                    }
                }

            }

        }

        return answer;
    }
}
