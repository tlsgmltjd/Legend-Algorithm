package baekjoon.b_1012;

import java.util.Scanner;

public class Main {

    static String[] 지렁이;
    static int[][] map;
    static int[] M, N;

    static int[] ySet = {0, -1, 0, 1};
    static int[] xSet = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        M = new int[T]; // 가로
        N = new int[T]; // 세로
        int[] K = new int[T];
        int[] count = new int[T];

        for (int i = 0; i < T; i++) {
            M[i] = sc.nextInt();
            N[i] = sc.nextInt();
            K[i] = sc.nextInt();
            map = new int[N[i]][M[i]];
            지렁이 = new String[K[i]];

            for (int j = 0; j < N[i]; j++) {
                for (int k = 0; k < M[i]; k++) {
                    map[j][k] = 0;
                }
            }

            for (int j = 0; j < K[i]; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                지렁이[j] = x + "/" + y;
                map[y][x] = 1;
            }

            for (int j = 0; j < 지렁이.length; j++) {
                String s = 지렁이[j];
                int x = Integer.parseInt(s.split("/")[0]);
                int y = Integer.parseInt(s.split("/")[1]);

                if (map[y][x] != 1) {
                    continue;
                }

                find(x, y, i);
                count[i]++;
            }
        }

        for (int c : count) {
            System.out.println(c);
        }

    }

    static void find(int x, int y, int i) {

        if (x < 0 || y < 0 || x >= (M[i]) || y >= (N[i])) {
            return;
        }
        map[y][x] = 2;

        for (int a = 0; a < 4; a++) {
            int nextX = x + xSet[a];
            int nextY = y + ySet[a];

            if (nextX < 0 || nextY < 0 || nextX >= (M[i]) || nextY >= (N[i])) {
                continue;
            }

            if (map[nextY][nextX] != 1) continue;

            map[nextY][nextX] = 2;

            find(nextX, nextY, i);
        }

    }
}
