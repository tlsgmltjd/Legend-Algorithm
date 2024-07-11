package baekjoon.b_1419_d;

import java.util.*;

public class Main {

    static Set<Long> set = new HashSet();
    static Queue<Atom> queue = new ArrayDeque();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long L = sc.nextInt();
        long R = sc.nextInt();
        long K = sc.nextInt();


        queue.add(new Atom(1, 1));

        while (true) {
            Atom atom = queue.poll();
            long sum = (K * (2 * atom.x + (K - 1) * atom.d)) / 2;

            if (sum >= L && sum <= R) {
                set.add(sum);
            }

            if (sum >= R) {
                System.out.println(set.size());
                return;
            }

            if (K >= 3) {
                queue.add(new Atom(atom.x + 1, atom.d));
                queue.add(new Atom(atom.x, atom.d + 1));
            } else {
                queue.add(new Atom(atom.x, atom.d + 1));
                queue.add(new Atom(atom.x + 1, atom.d));
            }
            }
        }

    static class Atom {
        int x;
        int d;

        public Atom(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }
}
