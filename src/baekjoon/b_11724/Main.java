package baekjoon.b_11724;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean visited[];
    static ArrayList<Integer>[] grape;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int E = Integer.parseInt(sc.next());

        grape = new ArrayList[N+1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N+1; i++) {
            grape[i] = new ArrayList();
            visited[i] = false;
        }

        for (int i = 1; i < E+1; i++) {
            int from = Integer.parseInt(sc.next());
            int to = Integer.parseInt(sc.next());

            grape[from].add(to);
            grape[to].add(from);
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }

        System.out.println(res);

    }

    static void dfs(int start) {
        visited[start] = true;
        for (int m : grape[start]) {
            if (!visited[m]) {
                dfs(m);
            }
        }
    }
}
