package baekjoon.b_5525;

import java.io.*;

// 부분성공

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String ioio = "";

        for (int i = 0; i < M; i++) {
            ioio += S.charAt(i);
        }

        String target = "";
        boolean temp = true; // I

        for (int i = 0; i < (N + N + 1); i++) {
            target += temp ? "I" : "O";
            temp = !temp;
        }

        int count = 0;

        for (int i = 0; i < M; i++) {

            if (M < (N + N + 1) + i) break;

            if (ioio.substring(i, (N + N + 1) + i).equals(target)) {
                count++;
            }
        }

        bw.write(count + "");

        bw.flush();
        bw.close();

    }

}
