package baekjoon.b_2606;

import java.util.*;
// 인접리스트 + 방문한 노드 재방문 하지 않도록 구형
public class Main {

    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] visited;
    static int C;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        int N = sc.nextInt();

        visited = new boolean[C + 1];

        for (int i = 0; i < C+1; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();

            g.get(f).add(s);
            g.get(s).add(f);
        }

        find(1);
        set.add(1);
        System.out.println(set.size()-1);

    }

    static void find(int target) {
        visited[target] = true;
        for (int i = 0; i < g.get(target).size(); i++) {
            Integer n = g.get(target).get(i);
            if (!visited[n]) {
                set.add(n);
                find(n);
            }
        }
    }
}

// 2 3 5 6