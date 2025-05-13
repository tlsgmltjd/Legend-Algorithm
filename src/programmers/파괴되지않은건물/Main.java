package programmers.파괴되지않은건물;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int a = solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}
                );
        System.out.println(a);
    }

    public static int solution(int[][] board, int[][] skill) {

        AtomicInteger answer = new AtomicInteger();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] > 0) {
                    answer.getAndIncrement();
                }
            }
        }

        Arrays.stream(skill).forEach(row -> {
            int type = row[0];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = row[5];

            int width = c2 - c1 + 1;
            int height = r2 - r1 + 1;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (type == 1) {

                        if (board[r1 + i][c1 + j] < 1) {
                            board[r1 + i][c1 + j] -= degree;
                        } else {

                            board[r1 + i][c1 + j] -= degree;

                            if (board[r1 + i][c1 + j] < 1) {
                                answer.getAndDecrement();
                            }

                        }

                    } else {

                        if (board[r1 + i][c1 + j] > 0) {
                            board[r1 + i][c1 + j] += degree;
                        } else {
                            board[r1 + i][c1 + j] += degree;

                            if (board[r1 + i][c1 + j] > 0) {
                                answer.getAndIncrement();
                            }
                        }

                    }
                }
            }
        });

        return answer.get();
    }

}
