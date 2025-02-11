package baekjoon.b_14503;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int direct = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 0: 청소 X, 1: 벽, 2: 청소 O

        int clean = 0;

        while (true) {
            // 1
            if (map[r][c] == 0) {
                map[r][c] = 2;
                clean++;
            }

            // 주변 4칸이 청소되지 않은 빈칸이 없을 때
            // 2
            if (
                    (r + 1 >= n || map[r + 1][c] != 0) &&
                    (c + 1 >= m || map[r][c + 1] != 0) &&
                    (r - 1 < 0 || map[r - 1][c] != 0) &&
                    (c - 1 < 0 || map[r][c - 1] != 0)
            ) {
                switch (direct) {
                    case 2: {
                        if (r - 1 >= 0 && (map[r - 1][c] == 0 || map[r - 1][c] == 2)) {
                            r--;
                        } else {
                            System.out.println(clean);
                            return;
                        }
                        break;
                    }
                    case 1: {
                        if (c - 1 >= 0 && (map[r][c - 1] == 0 || map[r][c - 1] == 2)) {
                            c--;
                        } else {
                            System.out.println(clean);
                            return;
                        }
                        break;
                    }
                    case 0: {
                        if (r + 1 < n && (map[r + 1][c] == 0 || map[r + 1][c] == 2)) {
                            r++;
                        } else {
                            System.out.println(clean);
                            return;
                        }
                        break;
                    }
                    case 3: {
                        if (c + 1 < m && (map[r][c + 1] == 0 || map[r][c + 1] == 2)) {
                            c++;
                        } else {
                            System.out.println(clean);
                            return;
                        }
                        break;
                    }
                }
            }
            // 3
            else {
                // 3.1
                if (direct == 0) {
                    direct = 3;
                } else {
                    direct--;
                }

                // 3.2
                switch (direct) {
                    case 0: {
                        if (r - 1 >= 0 && map[r - 1][c] == 0) {
                            r--;
                        }
                        break;
                    }
                    case 3: {
                        if (c - 1 >= 0 && map[r][c - 1] == 0) {
                            c--;
                        }
                        break;
                    }
                    case 2: {
                        if (r + 1 < n && map[r + 1][c] == 0) {
                            r++;
                        }
                        break;
                    }
                    case 1: {
                        if (c + 1 < m && map[r][c + 1] == 0) {
                            c++;
                        }
                        break;
                    }
                }
            }

        }

    }
}