package baekjoon.b_13335;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();
        int[] car = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            car[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (deque.size() == w) {
                Integer poll = deque.pollFirst();
                sum -= poll;
            }

            if (i == 0) {
                sum += car[i];
                deque.add(car[i]);
            } else if (car[i] + sum <= l) {
                sum += car[i];
                deque.add(car[i]);
            } else {
                deque.add(0);
                i--;
            }

            count++;
        }

        System.out.println(count + w);

    }
}
