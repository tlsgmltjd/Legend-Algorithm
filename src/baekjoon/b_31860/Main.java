package baekjoon.b_31860;

import java.io.*;
import java.util.*;

// 열심히 일하는 중
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue task = new PriorityQueue<Integer>(Collections.reverseOrder());
        List<Integer> C = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            task.add(Integer.parseInt(br.readLine()));
        }

        int day = 0;
        int lastC = 0;

        while ((int) task.peek() > K) {
            int td = (lastC / 2) + (int) task.peek();
            lastC = td;

            task.add((int) task.poll() - M);
            C.add(td);
            day++;
        }

        bw.write(day + "");
        bw.newLine();

        C.forEach(a -> {
            try {
                bw.write(a + "");
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();

    }
}
