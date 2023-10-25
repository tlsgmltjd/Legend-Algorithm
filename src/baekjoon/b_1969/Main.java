package baekjoon.b_1969;

import java.util.*;

// DNA
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String [] DNA = new String[N];
        int hd = 0;
        StringBuilder GoodDNA = new StringBuilder();

        for (int i = 0; i < N; i++) {
            DNA[i] = in.next();
        }

        for (int i = 0; i < M; i++) {
            int A = 0;
            int T = 0;
            int G = 0;
            int C = 0;
            int max;
            for (int j = 0; j < N; j++) {

                switch (DNA[j].charAt(i)) {
                    case 'A' :
                        A++;
                        break;
                    case 'T' :
                        T++;
                        break;
                    case 'G' :
                        G++;
                        break;
                    case 'C' :
                        C++;
                        break;
                }
            }

            max = Math.max(A, Math.max(C, Math.max(G, T)));

            String maxWord;
            if (max == A) {
                maxWord = "A";
            } else if (max == C) {
                maxWord = "C";
            } else if (max == G) {
                maxWord = "G";
            } else if (max == T) {
                maxWord = "T";
            } else {
                maxWord = null;
            }

            GoodDNA.append(maxWord);
            hd += (A + T + G + C);

            switch (maxWord) {
                case "A" :
                    hd-=A;
                    break;
                case "C" :
                    hd-=C;
                    break;
                case "G" :
                    hd-=G;
                    break;
                case "T" :
                    hd-=T;
                    break;
            }
        }

        System.out.println(GoodDNA);
        System.out.println(hd);
    }
}