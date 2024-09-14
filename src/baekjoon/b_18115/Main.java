package baekjoon.b_18115;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());

        for (int num = 1; num <= N; num++) {

            int i = Integer.parseInt(st.nextToken());

            if (i == 1) {
                dq.addFirst(num);
            } else if (i == 2) {

                Integer pop = dq.pop();
                dq.addFirst(num);
                dq.addFirst(pop);


            } else {
                dq.addLast(num);
            }

        }

        for (Integer i : dq) {
            bw.write(i + " ");
        }


        bw.flush();
        bw.close();
    }
}
