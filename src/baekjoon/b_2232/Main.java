package baekjoon.b_2232;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] mine = new int[N];
        List<List<Integer>> bbb = new ArrayList<>(N);
        int[][] size = new int[N][2];

        for (int i = 0; i < N; i++) {
            mine[i] = sc.nextInt();
            bbb.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int now = i + 1;
            List<Integer> currentBom = bbb.get(i);
            currentBom.add(now);

            for (int j = 0; j < i; j++) {
                if (mine[i - (j + 1)] < mine[i - j]) {
                    currentBom.add(i - (j + 1) + 1);
                } else {
                    break;
                }
            }

            for (int j = 0; ((N-1) - j) > i; j++) {
                if (mine[i + (j + 1)] < mine[i + j]) {
                    currentBom.add(i + (j + 1) + 1);
                } else {
                    break;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            size[i][0] = bbb.get(i).size();
            size[i][1] = i + 1;
        }

        Arrays.sort(size, (a, b) -> {
            int result = Integer.compare(b[0], a[0]);
            if (result == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return result;
        });

        boolean[] table = new boolean[N];
        PriorityQueue<Integer> result = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int now = size[i][1] - 1;
            List<Integer> currentBom = bbb.get(now);

            boolean isOk = true;

            for (int j : currentBom) {
                if (!table[j - 1]) {
                    isOk = true;
                    break;
                } else {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) continue;

            for (int j : currentBom) {
                table[j - 1] = true;
            }

            result.offer(now + 1);
        }

        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}
