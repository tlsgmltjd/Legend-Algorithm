package baekjoon.b_9012;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        String[] pars = new String[T];

        for (int i = 0; i < T; i++) {
            pars[i] = in.next();
        }

        for (int i = 0; i < T; i++) {
            int left = 0;
            for (int j = 0; j < pars[i].length(); j++) {
                if (pars[i].charAt(j) == '(') {
                    left++;
                } else if (pars[i].charAt(j) == ')' && left > 0) {
                    left--;
                } else {
                    left = -1;
                    break;
                }
            }

            if (left == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}