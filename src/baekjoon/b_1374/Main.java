package baekjoon.b_1374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();
        char[] chars = new char[n];

        List<Character> moves = new ArrayList<Character>();

        for (int i = 0; i < n; i++) {
            chars[i] = s.charAt(i);
        }

        char status = 'S';

        int R = 0;
        int C = 0;

        int minR = 0;
        int maxR = 0;

        int minC = 0;
        int maxC = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] == 'R') {
                switch (status) {
                    case 'S': {
                        status = 'W';
                        break;
                    }
                    case 'W': {
                        status = 'N';
                        break;
                    }
                    case 'E': {
                        status = 'S';
                        break;
                    }
                    case 'N': {
                        status = 'E';
                        break;
                    }
                }
            } else if (chars[i] == 'L') {
                switch (status) {
                    case 'S': {
                        status = 'E';
                        break;
                    }
                    case 'W': {
                        status = 'S';
                        break;
                    }
                    case 'E': {
                        status = 'N';
                        break;
                    }
                    case 'N': {
                        status = 'W';
                        break;
                    }
                }
            } else if (chars[i] == 'F') {
                moves.add(status);
                switch (status) {
                    case 'S': {
                        C++;
                        break;
                    }
                    case 'W': {
                        R--;
                        break;
                    }
                    case 'E': {
                        R++;
                        break;
                    }
                    case 'N': {
                        C--;
                        break;
                    }
                }

                minR = Math.min(minR, R);
                maxR = Math.max(maxR, R);
                minC = Math.min(minC, C);
                maxC = Math.max(maxC, C);
            }
        }

        int bc = maxC - minC + 1;
        int br = maxR - minR + 1;

        int startC = Math.abs(minC);
        int startR = Math.abs(minR);

        char[][] map = new char[bc][br];

        for (int i = 0; i < bc; i++) {
            Arrays.fill(map[i], '#');
        }

        map[startC][startR] = '.';

        for (Character move : moves) {
            switch (move) {
                case 'S': {
                    startC++;
                    map[startC][startR] = '.';
                    break;
                }
                case 'W': {
                    startR--;
                    map[startC][startR] = '.';
                    break;
                }
                case 'E': {
                    startR++;
                    map[startC][startR] = '.';
                    break;
                }
                case 'N': {
                    startC--;
                    map[startC][startR] = '.';
                    break;
                }
            }
        }

        for (int i = 0; i < bc; i++) {
            for (int j = 0; j < br; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
