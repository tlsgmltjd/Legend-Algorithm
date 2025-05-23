package programmers.비밀코드해독;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a = solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}, new int[]{2, 3, 4, 3, 3});
        System.out.println(a);
    }

    public static int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        int[] arr = new int[n];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        bt(arr, 5, 0, new ArrayList<>(), result);

        int size = result.size();

        for (int i = 0; i < size; i++) {
            boolean candy = true;

            for (int j = 0; j < q.length; j++) {
                int finalI = i;
                int finalJ = j;
                long count = result.get(finalI).stream().filter(r -> {
                    for (int k = 0; k < q[finalJ].length; k++) {
                        if (q[finalJ][k] == r) return true;
                    }
                    return false;
                }).count();

                if (count != ans[j]) {
                    candy = false;
                    break;
                }
            }

            if (candy) {
                answer++;
            }

        }

        return answer;
    }

    public static void bt(int[] arr, int r, int start, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == r) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            cur.add(arr[i]);
            bt(arr, r, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
