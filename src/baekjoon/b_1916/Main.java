package baekjoon.b_1916;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        long[] shortCut = new long[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
            shortCut[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int l = sc.nextInt();

            if (graph[s][e] == 1000001) {
                graph[s][e] = l;
            } {
                if (graph[s][e] > l) {
                    graph[s][e] = l;
                }
            }
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        if (s == e) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }

        // 시작점 기준 초기화 단계
        visited[s] = true;
        shortCut[s] = 0;
        for (int i = 1; i <= n; i++) {
            int li = graph[s][i];

            if (li != -1) {
                shortCut[i] = li;
            }
        }

        for (int i = 1; i < n; i++) {
            long minV = Integer.MAX_VALUE;
            int minE = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (shortCut[j] < minV) {
                        minV = shortCut[j];
                        minE = j;
                    }
                }
            }

            if (minV == -1 || minE == -1) {
                break;
            }

            visited[minE] = true;

            for (int j = 1; j <= n; j++) {
                if (graph[minE][j] != -1) {
                    if (graph[minE][j] + shortCut[minE] < shortCut[j]) {
                        shortCut[j] = graph[minE][j] + shortCut[minE];
                    }
                }
            }
        }

        System.out.println(shortCut[e]);

    }
}
