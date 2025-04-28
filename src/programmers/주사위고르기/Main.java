package programmers.주사위고르기;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> result2;

    public static void main(String[] args) {
        int[] v = solution(new int[][]
//                {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}}

                {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}}

//                        {{1,2}, {3,4}, {11,2}, {1,23}, {15,2}, {17,2}}

        );

        for (int i : v) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[][] dice) {
        int n = dice.length;
        int k = dice.length / 2;

        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);

        int[][] sum = new int[result.size()][(int) Math.pow(dice[0].length, result.get(0).size())];

        int temp = 0;

        for (List<Integer> comb : result) {
            int[][] arr = new int[comb.size()][dice[0].length];
            int idx = 0;

            for (Integer c : comb) {
                arr[idx] = dice[c - 1];
                idx++;
            }
            result2 = new ArrayList<>();
            backtrack2(arr, 0, 0);

            sum[temp] = result2.stream().mapToInt(i -> i).toArray();

            temp++;
        }

        int[][] recode = new int[sum.length / 2][3];

        for (int i = 0; i < sum.length / 2; i++) {
            int[] revers = sum[sum.length - 1 - i];

            int win = 0;
            int draw = 0;
            int lose = 0;

            for (int m = 0; m < sum[i].length; m++) {
                for (int q = 0; q < sum[i].length; q++) {
                    if (sum[i][m] > revers[q]) {
                        win++;
                    } else if (sum[i][m] == revers[q]) {
                        draw++;
                    } else if (sum[i][m] < revers[q]) {
                        lose++;
                    }
                }
            }


            recode[i][0] = win;
            recode[i][1] = draw;
            recode[i][2] = lose;
        }

        int[] winCount = new int[result.size()];
        for (int i = 0; i < recode.length; i++) {
            winCount[i] = recode[i][0];
            winCount[i+recode.length] = recode[i][2];
        }

        int max = -1;
        int answerIdx = -1;

        for (int i = 0; i < winCount.length; i++) {
            if (max < winCount[i]) {
                max = winCount[i];
                answerIdx = i;
            }
        }

        return result.get(answerIdx).stream()
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
