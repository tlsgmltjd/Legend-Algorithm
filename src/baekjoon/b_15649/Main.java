package baekjoon.b_15649;

import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        go(N, M, 0);

    }

    static void go(int N, int M, int 깊이) {
        if (M == 깊이) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[깊이] = i + 1;
                go(N, M, 깊이 + 1);
                visit[i] = false;
            }
        }
    }

}
