package baekjoon.b_1996;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        Character[][] map = new Character[N][N];
        Character[][] result = new Character[N][N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = input[i].charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int mine = 0;

                if (map[i][j] == '.') {
                    if (j - 1 >= 0 && map[i][j - 1] != null && map[i][j - 1] != '.') {
                        mine += Character.getNumericValue(map[i][j - 1]);
                    }
                    if (j - 1 >= 0 && i + 1 <= N - 1 && map[i + 1][j - 1] != null && map[i + 1][j - 1] != '.') {
                        mine += Character.getNumericValue(map[i + 1][j - 1]);
                    }
                    if (j - 1 >= 0 && i - 1 >= 0 && map[i - 1][j - 1] != null && map[i - 1][j - 1] != '.') {
                        mine += Character.getNumericValue(map[i - 1][j - 1]);
                    }
                    if (i - 1 >= 0 && map[i - 1][j] != null && map[i - 1][j] != '.') {
                        mine += Character.getNumericValue(map[i - 1][j]);
                    }
                    if (i - 1 >= 0 && j + 1 <= N - 1 && map[i - 1][j + 1] != null && map[i - 1][j + 1] != '.') {
                        mine += (Character.getNumericValue(map[i - 1][j + 1]));
                    }
                    if (j + 1 <= N - 1 && map[i][j + 1] != null && map[i][j + 1] != '.') {
                        mine += Character.getNumericValue(map[i][j + 1]);
                    }
                    if (j + 1 <= N - 1 && i + 1 <= N - 1 && map[i + 1][j + 1] != null && map[i + 1][j + 1] != '.') {
                        mine += Character.getNumericValue(map[i + 1][j + 1]);
                    }
                    if (i + 1 <= N - 1 && map[i + 1][j] != null && map[i + 1][j] != '.') {
                        mine += Character.getNumericValue(map[i + 1][j]);
                    }

                    if (mine >= 10) {
                        result[i][j] = 'M';
                    } else {
                        result[i][j] = Integer.toString(mine).charAt(0);
                    }

                } else {
                    result[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}
