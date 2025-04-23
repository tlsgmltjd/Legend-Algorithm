package baekjoon.b_2096;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] map = new int[n][3];
        int[][] maxMap = new int[n][3];
        int[][] minMap = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int value = sc.nextInt();
                map[i][j] = value;
                maxMap[i][j] = value;
                minMap[i][j] = value;
            }
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < 3; j++) {
                maxMap[i + 1][j] = Math.max(maxMap[i + 1][j], map[i + 1][j] + maxMap[i][j]);

                if (j - 1 >= 0) {
                    maxMap[i + 1][j - 1] = Math.max(maxMap[i + 1][j - 1], map[i + 1][j - 1] + maxMap[i][j]);
                }

                if (j + 1 < 3) {
                    maxMap[i + 1][j + 1] = Math.max(maxMap[i + 1][j + 1], map[i + 1][j + 1] + maxMap[i][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    minMap[i][j] += Math.min(minMap[i - 1][j], minMap[i - 1][j + 1]);
                } else if (j == 1) {
                    minMap[i][j] += Math.min(Math.min(minMap[i - 1][j], minMap[i - 1][j + 1]), minMap[i - 1][j - 1]);
                } else {
                    minMap[i][j] += Math.min(minMap[i - 1][j], minMap[i - 1][j - 1]);
                }
            }
        }

        int max = Math.max(Math.max(maxMap[n - 1][0], maxMap[n - 1][1]), maxMap[n - 1][2]);
        int min = Math.min(Math.min(minMap[n - 1][0], minMap[n - 1][1]), minMap[n - 1][2]);

        System.out.println(max + " " + min);
    }

}
