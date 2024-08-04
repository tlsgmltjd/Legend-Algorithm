package baekjoon.b_1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Dfs (x, y, count) {
 *
 * count == K && 도착 지점 좌표와 같다면
 * - 결과값 + 1
 *
 * 4방향 탐색 진행 (상하좌우)
 *
 * 벽을 뚫지는 않았는지 확인
 * - .인가? && 방문하진 않았는가
 *     - 다음 장소 방문처리
 *     - 재귀 실행
 *     - 방문 해제
 * }
 */

public class Main {


    static int[] ySet = {0, -1, 0, 1};
    static int[] xSet = {1, 0, -1, 0};
    static int R, C, K, result;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                map[i][j] = charArray[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = false;
            }
        }

        visited[R - 1][0] = true;
        dfs(0, R - 1, 1);

        System.out.println(result);

    }


    static void dfs(int x, int y, int count) {
        if (count == K) {
            if (x == (C - 1) && y == 0) {
                result++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + xSet[i];
            int nextY = y + ySet[i];

            if (nextX < C && nextY < R && nextY >= 0 && nextX >= 0) {
                if (map[nextY][nextX] == '.' && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;

                    dfs(nextX, nextY, count + 1);

                    visited[nextY][nextX] = false;
                }
            }
        }

    }

}
