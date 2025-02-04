package baekjoon.b_1149;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int []> table = new ArrayList<int []>();

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            table.add(new int [] {r, g, b});
        }

        // 각 칸의 경우의 수
        // 1 | 1 | 1
        // 2(i-1: g,b) | 2(i-1: r,b) | 2(i-1: r,g)
        // 4(i-1: g,b) | 4(i-1: r,b) | 4(i-1: r,g)

        // i-1 g,b r,b r,g 중 작은 값과 현재 칸의 값을 더하면
        // n-1의 칸의 r,g,b 중에는 최저 값이 나온다.

        for (int i = 1; i < n; i++) {
            table.get(i)[0] += Math.min(table.get(i-1)[1], table.get(i-1)[2]);
            table.get(i)[1] += Math.min(table.get(i-1)[0], table.get(i-1)[2]);
            table.get(i)[2] += Math.min(table.get(i-1)[0], table.get(i-1)[1]);
        }

        System.out.println(
                Math.min(Math.min(table.get(n-1)[0], table.get(n-1)[1]), table.get(n-1)[2])
        );


    }

}

// 71 [39] 44
// [32] 83 55
// 51 [37] 63
// [89] 29 100
// 83 58 [11]
// 65 [13] 15
// 47 25 [29]
// [60] 66 19