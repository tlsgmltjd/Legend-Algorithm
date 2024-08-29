package baekjoon.b_11399;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int[] store = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int p = pq.poll();
            store[i] = p + sum;
            sum += p;
        }

        int res = 0;
        for (int i : store) {
            res += i;
        }

        System.out.println(res);
    }
}
