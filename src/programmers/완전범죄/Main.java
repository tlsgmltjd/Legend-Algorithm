package programmers.완전범죄;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = solution(new int[][]{{1,2}, {2,3}, {2,1}}, 4,4);
        System.out.println(a);
    }

    public static int solution(int[][] info, int n, int m) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0, 0});

        boolean[][][] visited = new boolean[n][m][info.length + 1];
        int minA = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int traceA = cur[0], traceB = cur[1], idx = cur[2];

            if (traceA >= n || traceB >= m) continue;
            if (visited[traceA][traceB][idx]) continue;
            visited[traceA][traceB][idx] = true;

            if (idx == info.length) {
                minA = Math.min(minA, traceA);
                continue;
            }

            int aTrace = info[idx][0];
            int bTrace = info[idx][1];

            stack.push(new int[]{traceA + aTrace, traceB, idx + 1});
            stack.push(new int[]{traceA, traceB + bTrace, idx + 1});
        }

        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
}
