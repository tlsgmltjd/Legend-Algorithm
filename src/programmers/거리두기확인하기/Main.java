package programmers.거리두기확인하기;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] solution = solution(new String[][]{
                {"OOOOO", "OOOOO", "OPOPO", "OOOOO", "OOOOO"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static  int[] solution(String[][] places) {
        List<Integer> answer = new LinkedList<>();

        for (String[] place : places) {
            boolean violation = false;

            for (int i = 0; i < 5 && !violation; i++) {
                for (int j = 0; j < 5 && !violation; j++) {
                    if (place[i].charAt(j) == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        visited[i][j] = true;
                        if (dfs(place, visited, i, j, 0)) {
                            violation = true;
                        }
                    }
                }
            }

            answer.add(violation ? 0 : 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    static boolean dfs(String[] place, boolean[][] visited, int x, int y, int depth) {
        if (depth > 2) return false;

        if (depth >= 1 && place[x].charAt(y) == 'P') return true;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (visited[nx][ny] || place[nx].charAt(ny) == 'X') continue;

            visited[nx][ny] = true;
            if (dfs(place, visited, nx, ny, depth + 1)) return true;
            visited[nx][ny] = false;
        }

        return false;
    }
}
