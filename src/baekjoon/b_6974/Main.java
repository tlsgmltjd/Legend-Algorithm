package baekjoon.b_6974;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            BigInteger n = new BigInteger(sc.next());
            BigInteger m = new BigInteger(sc.next());

            StringBuilder mok = new StringBuilder();

            int loop = n.toString().length() - m.toString().length();
            for (int j = 0; j <= loop; j++) {
                BigInteger a = BigInteger.ZERO;
                BigInteger factor = m.multiply(BigInteger.TEN.pow(loop - j));
                while (n.compareTo(factor) >= 0) {
                    n = n.subtract(factor);
                    a = a.add(BigInteger.ONE);
                }
                mok.append(a);
            }

            System.out.println(mok);
            System.out.println(n);
            System.out.println();
        }
    }
}
