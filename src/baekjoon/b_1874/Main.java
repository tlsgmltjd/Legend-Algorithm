package baekjoon.b_1874;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sequence = new int[n];
        int target = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
            pq.add(sequence[i]);
        }

        List<Character> answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(pq.poll());
        answer.add('+');

        while (target != n) {

            if (stack.isEmpty()) {
                stack.push(pq.poll());
                answer.add('+');
            }

            if (stack.peek() == sequence[target]) {
                answer.add('-');
                stack.pop();
                target++;

                if (target == n) {
                    break;
                }
            } else {

                if (pq.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                stack.push(pq.poll());
                answer.add('+');
            }
        }

        answer.forEach(System.out::println);

    }
}
