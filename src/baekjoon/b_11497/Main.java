package baekjoon.b_11497;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List result = new ArrayList();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();
            int[] asd = new int[M];
            for (int j = 0; j < M; j++) {
                priorityQueue.add(sc.nextInt());
            }

            for (int k = 0; k < (M / 2) + (M % 2); k++) {

                if (asd[k] == 0) {
                    asd[k] = priorityQueue.poll();
                }

                if (asd[M - k-1] == 0) {
                    asd[M - k - 1] = priorityQueue.poll();
                }

            }

            // ^
            // 1 3 5 4 2 <- 이런식으로 정렬 인접한 높히가 최대한 적게

            int max = -1;

            for (int k = 0; k < (M-1); k++) {
                if (max == -1) {
                    max = Math.abs(asd[k] - asd[k + 1]);
                } else {
                    if (max < Math.abs(asd[k] - asd[k + 1])) {
                        max = Math.abs(asd[k] - asd[k + 1]);
                    }
                }
            }

            // ^
            // 인접한 높이 차이가 가장 큰 값 찾기

            result.add(max);

        }

        result.forEach(
                System.out::println
        );


    }
}
