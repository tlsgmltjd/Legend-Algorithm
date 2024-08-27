package baekjoon.b_1946;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        List<Integer> res = new ArrayList<>();

        for (int a = 0; a < T; a++) {

            int N = Integer.parseInt(br.readLine());
            int[][] app = new int[2][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                app[0][i] = Integer.parseInt(st.nextToken());
                app[1][i] = Integer.parseInt(st.nextToken());
            }

            int no = 0;

            for (int i = 0; i < N; i++) {
                int f = app[0][i];
                int s = app[1][i];

                for (int j = 0; j < N; j++) {
                    if (j == i) continue;

                    if (f > app[0][j] && s > app[1][j]) {
                        no++;
                        break;
                    }
                }
            }

            res.add(N - no);

        }

        for (Integer re : res) {
            bw.write(re + "\n");
        }

        bw.flush();
        bw.close();
    }
}
