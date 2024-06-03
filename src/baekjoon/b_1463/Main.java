package baekjoon.b_1463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];

        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i-1] + 1;

            if (i % 2 == 0)
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            if (i % 3 == 0)
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
        }

        bw.write(DP[N] + "");

        bw.flush();
        bw.close();
    }
}

// dp
// 최소횟수 : N-1의 최소횟수 + 1 OR 2 or 3으로 나누어지면 몫의 최소횟수 + 1
// 0 0 0 0 0 0 0 [7]
// N : 6
// 2 -> 1
// 3 -> (1+1) -> 1
// 4 -> (1+1) -> 2
// 5 -> (2+1) -> 3
// 6 -> (3+1) -> 2
