package baekjoon.b_13549;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] visited = new int[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 1});
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] * 2 <= 100000 && (visited[now[0] * 2] == 0 || visited[now[0] * 2] > now[1])) {
                visited[now[0] * 2] = now[1];
                queue.add(new int[]{now[0] * 2, now[1]});
            }

            if (now[0] - 1 >= 0 && (visited[now[0] - 1] == 0 || visited[now[0] - 1] > now[1] + 1)) {
                visited[now[0] - 1] = now[1] + 1;
                queue.add(new int[]{now[0] - 1, now[1] + 1});
            }

            if (now[0] + 1 <= 100000 && (visited[now[0] + 1] == 0 || visited[now[0] + 1] > now[1] + 1)) {
                visited[now[0] + 1] = now[1] + 1;
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }

        }

        System.out.println(visited[k] - 1);
    }
}

