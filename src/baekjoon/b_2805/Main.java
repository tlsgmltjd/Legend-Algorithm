package baekjoon.b_2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int max = Arrays.stream(tree).max().getAsInt();
        int temp = max;

        int min = 0;

        while (min < max) {

            long sum = 0;
            int mid = ((max - min) / 2) + min;

            for (int i : tree) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (sum < M) {
                max = mid;
            }

            else {
                min = mid + 1;
            }
        }

        bw.write((min - 1) + "");

        bw.flush();
        bw.close();

    }
}
