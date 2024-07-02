package baekjoon.b_1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[i][0] = l;
            arr[i][1] = r;
        }


        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int temp = 1;
        int temp2 = arr[0][1];

        for (int i = 0; i < N; i++) {

            if (i == 0) {
                continue;
            }

            if (temp2 <= arr[i][0]) {
                temp++;
                temp2 = arr[i][1];
            }
        }

        bw.write(temp + "");

        bw.flush();
        bw.close();
    }

}
