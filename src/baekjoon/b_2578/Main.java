package baekjoon.b_2578;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer [][] bingo = new Integer[5][5];
        Integer [][] answer = new Integer[5][5];
        int turn = 0;
        int win = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer[i][j] = in.nextInt();
            }
        }

        for (int ia = 0; ia < 5; ia++) {
            for (int ja = 0; ja < 5; ja++) {

                int ans = answer[ia][ja];
                for (int a = 0; a < 5; a++) {
                    for (int b = 0; b < 5; b++) {
                        if (bingo[a][b] == ans) {
                            bingo[a][b] = -1;
                        }
                    }
                }

                boolean isBingo = false;
                for (int i = 0; i < 5; i++) {

                    for (int j = 0; j < 5; j++) {
                        if (bingo[i][j] == -1) {
                            isBingo = true;
                        }  else {
                            isBingo = false;
                            break;
                        }
                    }
                    if (isBingo) {
                        win++;
                    }
                }

                isBingo = false;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (bingo[j][i] == -1) {
                            isBingo = true;
                        }  else {
                            isBingo = false;
                            break;
                        }
                    }
                    if (isBingo) {
                        win++;
                    }
                }

                isBingo = false;
                for (int i = 0; i < 5; i++) {
                    if (bingo[i][i] == -1) {
                        isBingo = true;
                    } else {
                        isBingo = false;
                        break;
                    }
                }

                if (isBingo) {
                    win++;
                }

                isBingo = false;
                for (int i = 0; i < 5; i++) {
                    if (bingo[i][4 - i] == -1) {
                        isBingo = true;
                    } else {
                        isBingo = false;
                        break;
                    }
                }

                if (isBingo) {
                    win++;
                }

                turn++;

                if (win >= 3) {
                    System.out.println(turn);
                    return;
                } else {
                    win = 0;
                }
            }
        }
    }
}