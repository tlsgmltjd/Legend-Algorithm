package programmers.파괴되지않은건물;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a = solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}
                );
        System.out.println(a);
    }

    public static int solution(int[][] board, int[][] skill) {

        int[][] nujuk = new int[board.length+1][board[0].length+1];

        Arrays.stream(skill).forEach(row -> {
            int type = row[0];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = row[5];

            int d = type == 1 ? -degree : degree;

            nujuk[r1][c1] += d;
            nujuk[r1][c2+1] += (-d);
            nujuk[r2+1][c2+1] += d;
            nujuk[r2+1][c1] += (-d);
        });

        for (int row = 0; row < nujuk.length-1; row++) {
            for (int col = 0; col < nujuk[row].length-1; col++) {
                nujuk[row][col + 1] = nujuk[row][col + 1] + nujuk[row][col];
            }
        }


        for (int row = 0; row < nujuk[0].length-1; row++) {
            for (int col = 0; col < nujuk.length-1; col++) {
                nujuk[col + 1][row] = nujuk[col + 1][row] + nujuk[col][row];
            }
        }

        int answer = 0;

        for (int row = 0; row < nujuk.length-1; row++) {
            for (int col = 0; col < nujuk[row].length-1; col++) {
                if (board[row][col] + nujuk[row][col] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
