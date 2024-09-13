package baekjoon.b_4948;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> ls = new ArrayList<>();

        while (true) {
            int i = sc.nextInt();
            if (i == 0) break;
            else ls.add(i);
        }

        List<Integer> res = new ArrayList<>();

        ls.forEach(i -> {

            int s = i+1; // 14
            int e = i*2; // 26

            int sum = 0;

            // 14 ~ 26

            // 2 3 4* 5 6* 7 8* 9* 10* 11 12* 13
            // 14*, 15*, 16*, 17, 18*, 19
            // 20*, 21*, 22*, 23, 24*, 25*, 26*

            // 2 ~ 26
            int[] all = new int[e+2];
            for (int j = 2; j <= e; j++)
                all[j] = j;

            // "2" -> 4, "3" -> 9, "4" -> 16, "5" -> 25
            // 1. 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26
            // 2. 3, 6, 9, 12 ...

            for (int j = 2; j * j <= e; j++) {

                if (all[j] != 0) {

                    for (int q = j * j; q <= e; q+=j) {
                            all[q] = 0;
                    }

                }

            }

            for (int j = s; j <= e; j++) {
                if (all[j] != 0) {
                    sum++;
                }
            }

            res.add(sum);

        });

        res.forEach(r -> {
//                    System.out.println("==========");
                    System.out.println(r);
                }
        );

    }
}
