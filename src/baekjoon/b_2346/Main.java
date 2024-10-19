package baekjoon.b_2346;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<int[]> list = new LinkedList<>();

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(new int[]{sc.nextInt(), i});
        }

        List<Integer> res = new ArrayList<>();

        int idx = 0;
        int nowIdx = 0;
        int movIdx = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                idx = 0;
                int[] v = list.removeFirst();
                nowIdx = v[1];
                movIdx = v[0];

                res.add(nowIdx);
            } else {

                if (movIdx > 0) {
                    int find = idx + movIdx - 1;


                    while (find >= list.size()) {
                        find = find - list.size();
                    }


                    int[] pv = list.get(find);
                    idx = findIdx(pv[0], pv[1], list);

                    int[] v = list.remove(find);
                    nowIdx = v[1];
                    movIdx = v[0];

                    res.add(nowIdx);
                } else {
                    int mov = idx + movIdx;
                    int find;

                    if (mov < 0) {

                        find = list.size() + mov;

                        while (find < 0) {
                            find += list.size();
                        }

                    } else {
                        find = mov;
                    }

                    int[] pv = list.get(find);
                    idx = findIdx(pv[0], pv[1], list);

                    int[] v = list.remove(find);
                    nowIdx = v[1];
                    movIdx = v[0];


                    res.add(nowIdx);
                }
            }

        }

        res.forEach(r -> System.out.print(r+" "));

    }

    public static int findIdx(int i1, int i2, List<int[]> list) {
        int i = 0;

        for (int[] l : list) {
            if (l[0] == i1 && l[1] == i2) {
                break;
            }

            i++;
        }

        return i;
    }

}
