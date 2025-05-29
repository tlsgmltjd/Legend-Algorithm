package baekjoon.b_14865;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] node = new int[2][n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            node[0][i] = sc.nextInt();
            node[1][i] = sc.nextInt();

            max = Math.max(max, Math.max(Math.abs(node[0][i]), Math.abs(node[1][i])));
        }

        List<int[]> bong = new ArrayList<>();
        Stack<int []> stack = new Stack<>();

        for (int i = 0; i < n - 1; i++) {
            int x = node[0][i];
            int y = node[1][i];
            int nx = node[0][i + 1];
            int ny = node[1][i + 1];

            if (y < 0 && ny > 0) {
                stack.push(new int[] {x, 0});
            } else if (y > 0 && ny < 0) {
                if (!stack.isEmpty()) {
                    int[] left = stack.pop();
                    if (left[1] == 1) {
                        stack.push(left);
                    } else {
                        bong.add(new int[]{left[0], x, 0});
                    }
                } else {
                    stack.push(new int[] {x, 1});
                }
            }


            if (!stack.isEmpty() && i == n-2) {
                int[] left = stack.pop();
                bong.add(new int[]{left[0], nx, 0});
            }
        }

        // S: 2
        // M: 1
        // solo: 0

        bong.sort(Comparator.comparing(o -> -Math.abs(o[0] - o[1])));

        for (int i = 0; i < bong.size(); i++) {
            int x1 = Math.min(bong.get(i)[0], bong.get(i)[1]);
            int x2 = Math.max(bong.get(i)[0], bong.get(i)[1]);

            for (int j = 1 + i; j < bong.size(); j++) {
                int nx1 = Math.min(bong.get(j)[0], bong.get(j)[1]);
                int nx2 = Math.max(bong.get(j)[0], bong.get(j)[1]);

                if ((x1 < nx1 && nx1 < x2) && (x1 < nx2 && nx2 < x2)) {
                    if (bong.get(i)[2] == 2 || bong.get(i)[2] == 3) {
                        bong.get(j)[2] = 2;
                        bong.get(i)[2] = 3;
                        continue;
                    }

                    bong.get(j)[2] = 2;
                    bong.get(i)[2] = 1;
                }
            }
        }


//        for (int[] ints : bong) {
//            System.out.print(ints[0] + " " + ints[1] + " " + ints[2]);
//            System.out.println("======");
//        }

        int first = 0;
        int second = 0;

        for (int[] ints : bong) {
            if (ints[2] == 1 || ints[2] == 0) {
                first++;
            }
            if (ints[2] == 2 || ints[2] == 0) {
                second++;
            }
        }

        System.out.println(first + " " + second);
    }
}
