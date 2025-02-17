package baekjoon.b_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] < 0 || cur[0] > 100000) {
                continue;
            }

            if (!visited[cur[0]]) {
                visited[cur[0]] = true;

                if (cur[0] == k) {
                    System.out.println(cur[1]);
                    return;
                }

                queue.add(new int[]{cur[0]*2, cur[1]+1});
                queue.add(new int[]{cur[0]+1, cur[1]+1});
                queue.add(new int[]{cur[0]-1, cur[1]+1});
            }

        }

    }
}
