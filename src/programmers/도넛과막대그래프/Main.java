package programmers.도넛과막대그래프;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] res = solution(new int[][]{
                {2, 3}, {4, 3}, {1, 1}, {2, 1}
        });

        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static int[] solution(int[][] edges) {
        int[] answer = {};

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.add(new ArrayList<>());
        }

        int max = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);

            if (max < edge[1]) {
                max = edge[1];
            }
            if (max < edge[0]) {
                max = edge[0];
            }
        }

        for (int i = 1; i <= max; i++) {

            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            Set<Integer> visited = new HashSet<>();
            int line = 0;
            int lastNodeNum = -1;

            while (!stack.isEmpty()) {
                int node = stack.pop();

                visited.add(node);

                if (visited.contains(i) && node == i && graph.get(node).size() <= 1) {
                    continue;
                }

                stack.addAll(graph.get(node));

                if (stack.isEmpty()) {
                    lastNodeNum = node;
                }

                line += graph.get(node).size();
            }

            System.out.println(i + " " + lastNodeNum);
            System.out.println(line + " " + visited.size());

            if (lastNodeNum == i) {
                if (line == visited.size()) {
                    // 도넛
                    System.out.println("도넛 " + i);
                } else if (((visited.size() / 2.0) - 0.5) == ((line / 2.0) - 1)) {
                    // 8
                    System.out.println("8 " + i);
                }
            } else {
                System.out.println("else " + i);
            }

        }

        return answer;
    }

}
