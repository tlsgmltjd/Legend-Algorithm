//package baekjoon.b_1495;
//
//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int max = -1;
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N =  Integer.parseInt(st.nextToken());
//        int S =  Integer.parseInt(st.nextToken());
//        int M =  Integer.parseInt(st.nextToken());
//
//        int[] list = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            list[i] =  Integer.parseInt(st.nextToken());
//        }
//
//        int[][] dp = new int[N + 1][M + 1];
//
//        dp[0][S] = 1;
//
//        for (int i = 1; i < N+1; i++) {
//
//            for (int j = 0; j < M; j++) {
//
//                if (dp[i][j])
//
//            }
//
//        }
//
//        bw.write(max + "");
//
//        bw.flush();
//        bw.close();
//
//    }
//
//    static void go(int N, int S, int M, int 깊이, int[] list) {
//
//        System.out.println("깊이 : " + 깊이);
//
//        if (깊이 >= 1 && (S > M || S < 0)) {
//            return;
//        }
//
//        if (깊이 == N && max < S) {
//            max = S;
//            return;
//        }
//
//        if (깊이 == N) {
//            return;
//        }
//
//        go(N, S - list[깊이], M, 깊이 + 1, list);
//        go(N, S + list[깊이], M, 깊이 + 1, list);
//
//    }
//}
