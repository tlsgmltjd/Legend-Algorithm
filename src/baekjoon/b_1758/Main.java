package baekjoon.b_1758;

import java.util.*;

// 알바생 강호
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        Integer[] tips = new Integer[N];
        long tip = 0;


        for (int i = 0; i < N; i++) {
            tips[i] = in.nextInt();
        }

        Arrays.sort(tips, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            if ((tips[i] - i) >= 0)
                tip += (tips[i] - i);
            else
                break;
        }

        System.out.println(tip);
    }
}