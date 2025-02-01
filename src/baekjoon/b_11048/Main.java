package baekjoon.b_11048;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 첫 줄 세팅
        for (int i = 0; i < m; i++) {
            if (i != 0) {
                map[0][i] = map[0][i] + map[0][i - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 첫 번째 칸이면 해당 칸에 올 수 있는 경우의 수는 바로 위 칸 밖에 없음 (바로 위 칸 + 자신 칸 사탕 개수)
                if (j == 0) {
                    map[i][j] = map[i - 1][j] + map[i][j];
                } else {

                    // 해당 줄의 첫 번째 칸이 아니라면 해당 칸에 올 수 있는 경우의 수는 바로 위, 바로 왼쪽, 왼쪽 위 대각선
                    // 올 수 있는 경우의 칸의 사탕 개수가 가장 많은 것과 현재 칸의 사탕 수를 더해 현재 칸에 기록
                    int n1 = map[i-1][j];
                    int n2 = map[i-1][j-1];
                    int n3 = map[i][j-1];

                    int max = Math.max(n3, Math.max(n1, n2));

                    map[i][j] = max + map[i][j];
                }
            }
        }

        // 결국 마지막 칸에는 최대 사탕 수가 남음 q e d
        System.out.println(map[n-1][m-1]);

    }
}
