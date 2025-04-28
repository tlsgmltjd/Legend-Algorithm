package programmers.주사위고르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Integer> result2;

    public static void main(String[] args) {
        int[] v = solution(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        });

        for (int i : v) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[][] dice) {
        int n = dice.length;
        int k = n / 2;

        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);

        int[][] recode = new int[result.size()][2];

        for (int i = 0; i < result.size() / 2; i++) {
            List<Integer> aPick = result.get(i);

            List<Integer> bPick = new ArrayList<>();
            for (int d = 1; d <= n; d++) {
                if (!aPick.contains(d)) {
                    bPick.add(d);
                }
            }

            int[][] aArr = new int[aPick.size()][];
            int[][] bArr = new int[bPick.size()][];

            for (int j = 0; j < aPick.size(); j++) {
                aArr[j] = dice[aPick.get(j) - 1];
            }
            for (int j = 0; j < bPick.size(); j++) {
                bArr[j] = dice[bPick.get(j) - 1];
            }

            result2 = new ArrayList<>();
            backtrack2(aArr, 0, 0);
            int[] aSum = result2.stream().mapToInt(x -> x).toArray();

            result2 = new ArrayList<>();
            backtrack2(bArr, 0, 0);
            int[] bSum = result2.stream().mapToInt(x -> x).toArray();

            Arrays.sort(bSum);

            int win = 0;
            int lose = 0;
            for (int am : aSum) {
                int idx = Arrays.binarySearch(bSum, am);

                if (idx < 0) {
                    idx = -(idx + 1);
                    win += idx;
                    lose += bSum.length - idx;
                } else {
                    while (idx > 0 && bSum[idx - 1] == am) {
                        idx--;
                    }

                    int same = 0;
                    int tempIdx = idx;
                    while (tempIdx < bSum.length && bSum[tempIdx] == am) {
                        same++;
                        tempIdx++;
                    }

                    win += idx;
                    lose += bSum.length - idx - same;
                }

            }

            recode[i][0] = win;
            recode[i][1] = lose;

            recode[result.size() - i - 1][0] = lose;
            recode[result.size() - i - 1][1] = win;
        }

        int maxWin = -1;
        int bestIdx = -1;
        for (int i = 0; i < recode.length; i++) {
            if (recode[i][0] > maxWin) {
                maxWin = recode[i][0];
                bestIdx = i;
            }
        }

        return result.get(bestIdx).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, result);
            path.remove(path.size() - 1);
        }
    }

    private static void backtrack2(int[][] arr, int depth, int sum) {
        if (depth == arr.length) {
            result2.add(sum);
            return;
        }

        for (int i = 0; i < arr[depth].length; i++) {
            backtrack2(arr, depth + 1, sum + arr[depth][i]);
        }
    }
}