package baekjoon.b_11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> x = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp != 0) {
                x.add(temp);
            } else {
                if (x.size() == 0) {
                    bw.write(0 + "");
                    bw.newLine();
                } else {
                    int min = x.poll();
                    bw.write(min + "");
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();

    }
}
