package baekjoon.b_2885;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        List<Integer> sq = new ArrayList<>();
        int temp = 1;
        sq.add(temp);

        for (int i = 0; i < 21; i++) {
            temp = temp * 2;
            sq.add(temp);
        }

        int it = -1;
        int idx = -1;

        for (Integer i : sq) {

            if (K == i) {
                System.out.println(i + " " + 0);
                return;
            }
            else if (K < i) {
                it = i;
                idx = sq.indexOf(i);
                break;
            }
        }

        int answer = 0;
        int tit = it / 2;

        while (K > 0) {
            if ((K - tit) >= 0) {
                K = K - tit;
                tit = tit / 2;
            } else {
                tit = tit / 2;
            }

            answer++;
        }

        System.out.println(it + " " + answer);

    }
}
