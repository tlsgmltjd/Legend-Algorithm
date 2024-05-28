package baekjoon.b_1913;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] array = new int[N][N];

        int A = N / 2;
        int B = N / 2;
        int[] target = {A,B}; // M이 1일때 반례
        int temp = 1;
        int count = 1;
        boolean sw = false;

        array[A][B] = 1;

        while (true) {

            if (!(sw)) {
                for (int i = 1; i <= temp; i++) {
                    if (count >= N*N) break;
                    array[A][B - i] = ++count;

                    if (count == M) {
                        target[0] = A;
                        target[1] = B - i;
                    }
                }
                B-=temp;
                for (int i = 1; i <= temp; i++) {
                    if (count >= N*N) break;
                    array[A + i][B] = ++count;

                    if (count == M) {
                        target[0] = A + i;
                        target[1] = B;
                    }
                }
                A+=temp;
                temp++;
                sw = !sw;
            } else if (sw) {
                for (int i = 1; i <= temp; i++) {
                    if (count >= N*N) break;
                    array[A][B + i] = ++count;

                    if (count == M) {
                        target[0] = A;
                        target[1] = B + i;
                    }
                }
                B += temp;
                for (int i = 1; i <= temp; i++) {
                    if (count >= N*N) break;
                    array[A - i][B] = ++count;

                    if (count == M) {
                        target[0] = A - i;
                        target[1] = B;
                    }
                }
                A -= temp;
                temp++;
                sw = !sw;
            }

            if (count >= N*N) break;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write( array[j][i] + " ");
            }
            bw.newLine();
        }

        bw.write((target[1] + 1) + " " + (target[0] + 1));

        bw.flush();
        bw.close();
    }
}
