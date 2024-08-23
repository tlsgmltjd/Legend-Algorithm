package baekjoon.b_10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String N = sc.next();

        int res = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);

            if (c == '(') {
                // 레이저
                if (N.charAt(i+1) == ')') {
                    res += stack.size();
                    i++; // 건너뛰기
                } else {
                    res++;
                    stack.push(c);
                }
            }

            if (c == ')') {
                stack.pop();
            }
        }

        System.out.println(res);

    }
}
