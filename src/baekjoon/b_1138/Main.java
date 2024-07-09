package baekjoon.b_1138;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] line = new int[N + 1];
        List<Integer> aaa = new ArrayList();

        for (int i = 1; i <= N; i++) {
            line[i] = scanner.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            aaa.add(line[i], i);
        }

        for (Integer o : aaa) {
            System.out.print(o + " ");
        }

    }
}
