package baekjoon.b_1018_f;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char[][] chess = new char[M][N];
        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                chess[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (j != 0) {
                    if (chess[i][j-1] != chess[i][j]) {
                        sum++;
                    }
                }
            }

            width.add(sum);
        }


        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                if (j != 0) {
                    if (chess[j-1][i] != chess[j][i]) {
                        sum++;
                    }
                }
            }
            height.add(sum);
        }

        int widthMax = -1;
        int heightMax = -1;

        int widthIdx = 0;
        int heightIdx = 0;

        for (int i = 0; i < (N-8+1); i++) {
            int sum = 0;
            for (int j = i; j < 8 + i; j++) {
                sum += height.get(j);
            }

            if (heightMax < sum) {
                heightMax = sum;
                heightIdx = i;
            }
        }


        for (int i = 0; i < (M-8+1); i++) {
            int sum = 0;
            for (int j = i; j < 8 + i; j++) {
                sum += width.get(j);
            }

            if (widthMax < sum) {
                widthMax = sum;
                widthIdx = i;
            }
        }

        char[][] realChess = new char[8][8];

        for (int i = widthIdx; i < 8+widthIdx; i++) {
            for (int j = heightIdx; j < 8+heightIdx; j++) {
                realChess[i - widthIdx][j - heightIdx] = chess[i][j];
            }
        }

        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(realChess[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int res = -1;

        char[][] realChessCopy = new char[8][8];
        for (int i = 0; i < realChess.length; i++) {
            System.arraycopy(realChess[i], 0, realChessCopy[i], 0, realChess[i].length);
        }

        // true = B, false = W
        char level = 'W';
        int count1 = 0;
        count1 = getCount(realChess, level, count1);

        char level2 = 'B';
        int count2 = 0;
        count2 = getCount(realChessCopy, level2, count2);

        if (count1 > count2) {
            res = count2;
        } else {
            res = count1;
        }

        System.out.println(res);


    }

    private static int getCount(char[][] realChess, char level, int count) {
        for (int i = 0; i < 8; i++) {
            int current = realChess[i][0];
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    if (level == current) {
                        realChess[i][j] = realChess[i][j] == 'B' ? 'W' : 'B';
                        current = realChess[i][j];
                        count++;
                    }
                } else {
                    if (current == realChess[i][j]) {
                        realChess[i][j] = realChess[i][j] == 'B' ? 'W' : 'B';
                        count++;
                    }

                    current = realChess[i][j];
                }
            }

            level = level == 'B' ? 'W' : 'B';
        }
        return count;
    }
}
