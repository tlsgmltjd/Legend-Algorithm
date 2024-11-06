package programmers.택배배달과수거하기_unfin;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println(res);
    }
}

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        Stack<Integer> dS = new Stack<>();
        Stack<Integer> pS = new Stack<>();

        for (int i = 0; i < deliveries.length; i++) {
            dS.push(deliveries[i]);
        }

        for (int i = 0; i < pickups.length; i++) {
            pS.push(pickups[i]);
        }

        // dc: 4
        // pc: 4
        // 1, 0, 3, 1, 2
        // 0, 3, 0, 4, 0

        // legnth += 12

        // dc: 2
        // pc: 4
        // 1, 0, 3, 1
        // 0, 3, 0, 4

        // dc: 1
        // pc: 0
        // 1, 0, 3
        // 0, 3, 0

        // dc: 0
        // pc: 0
        // 1, 0, 2
        // 0, 3, 0

        int length = -1;

        while (!dS.isEmpty() || !pS.isEmpty()) {
            Integer dPop = dS.pop();
            Integer pPop = pS.pop();

            if (dPop != 0 || pPop != 0) {

//                System.out.println("============================");
//                System.out.println(dPop);
//                System.out.println(pPop);
//                System.out.println("============================");

                length += ((dS.size() + 1) * 2);

                int dCap = cap;
                int pCap = cap;

                while (true) {

                    if (pCap == 0 && dCap == 0) break;


                    if ((dPop - dCap) < 0) {
                        dCap -= dPop;
                    } else {
                        dS.push(dPop - dCap);
                        dCap = 0;
                    }

                    if ((pPop - pCap) < 0) {
                        pCap -= pPop;
                    } else {
                        if (pPop - pCap != 0) {
                            pS.push(pPop - pCap);
                        }
                        pCap = 0;
                    }

                    System.out.println("=========== " + dCap + " ========== " + pCap + " ===========");

                    dPop = dS.pop();
                    pPop = pS.pop();

                }
            }

        }

        return length;
    }
}
