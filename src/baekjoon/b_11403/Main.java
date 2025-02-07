package baekjoon.b_11403;

import java.util.Scanner;

public class Main {

    static int n;
    static int[][] map;
    static int[][] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                ans[i][j] = 0;
            }
        }


        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, visited);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int ri, int i, boolean[] visited) {
        for (int j = 0; j < n; j++) {
            if (map[i][j] == 1) {
                if (!visited[j]) {
                    visited[j] = true;
                    ans[ri][j] = 1;
                    dfs(ri, j, visited);
                }
            }
        }
    }

}
