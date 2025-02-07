package baekjoon.b_15686;

import java.util.*;

public class Main {

    static int n, m;
    static List<int[]> shopList;
    static List<int[]> homeList;
    static int minS = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        shopList = new ArrayList<>();
        homeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = sc.nextInt();
                if (v == 1) {
                    homeList.add(new int[]{i, j});
                } else if (v == 2) {
                    shopList.add(new int[]{i, j});
                }
            }
        }

        // 백트래킹으로 조합 생성 shopCount C m
        selectShops(new ArrayList<>(), 0);
        System.out.println(minS);

    }

    private static void selectShops(List<int[]> selected, int start) {
        if (selected.size() == m) {
            int sum = 0;

            for (int i = 0; i < homeList.size(); i++) {
                int v = calc(selected, i);
                sum += v;
            }

            if (sum < minS) {
                minS = sum;
            }

            return;
        }

        for (int i = start; i < shopList.size(); i++) {
            selected.add(shopList.get(i));
            selectShops(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static int calc(List<int[]> shop, int idx) {
        int h1 = homeList.get(idx)[0];
        int h2 = homeList.get(idx)[1];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < shop.size(); i++) {
            int s1 = shop.get(i)[0];
            int s2 = shop.get(i)[1];

            int v = Math.abs(s1 - h1) + Math.abs(s2 - h2);

            if (v < min) {
                min = v;
            }
        }

        return min;
    }

}