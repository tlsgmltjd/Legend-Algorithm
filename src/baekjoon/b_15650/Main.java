package baekjoon.b_15650;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int list[];
    static List<Integer> tempList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        initList(n);
        backtrack(n, m, 0);
    }

    private static void initList(int n) {
        list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i+1;
        }
    }

    static void backtrack(int n, int m, int count) {
        if (tempList.size() == m) {
            tempList.forEach(t -> System.out.print(t + " "));
            System.out.println();
            return;
        }

        for (int i = count; i < n; i++) {
            tempList.add(list[i]);
            backtrack(n, m, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

}
