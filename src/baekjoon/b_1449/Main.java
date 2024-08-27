package baekjoon.b_1449;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<Integer> sk = new Stack<>();
        List<Integer> lsk = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int 필요한테이프양 = 0;

        while (!pq.isEmpty()) {

            Integer poll = pq.poll();

//            System.out.println("============");
//            System.out.println("start : " + poll);
//            System.out.println("sk : " + sk.size());

            // 스택에 값이 없다면 스택에 add
            if (lsk.size() == 0) {
                lsk.add(poll);
//                System.out.println("none = " + poll);
            } else {

                Integer min = lsk.get(0);
//                System.out.println("peek = " + peek + " " + " poll = " + poll);

                // 가능한 수라면 스택에 add
                if (poll - min < L) {
                    lsk.add(poll);
//                    System.out.println("이웃 = " + poll);

                    // 이웃한 수가 아니라면
                } else {
                    필요한테이프양++;

                    lsk = new LinkedList<>();

//                    System.out.println("2 = " + poll);

                    pq.add(poll);

                    continue;
                }
            }


            // 테이프 양과 스택 양이 같다면
            if (lsk.size() == L) {
                필요한테이프양++;

//                System.out.println("OK + " + 필요한테이프양);

                lsk = new LinkedList<>();
            }
        }

        if (lsk.size() != 0) {
            필요한테이프양 += 1;
        }

        System.out.println(필요한테이프양);

    }
}
