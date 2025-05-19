package programmers.자물쇠와열쇠;

public class Main {
    public static void main(String[] args) {
        boolean s = solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        System.out.println(s);
    }

    // M과 N이 다른 경우 고려

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int[][][] cases = new int[4][lock.length + (lock.length - 1) * 2][lock.length + (lock.length - 1) * 2];

        for (int k = 0; k < 4; k++) {
            if (k == 0) {
                for (int i = 0; i < key.length; i++) {
                    for (int j = 0; j < key.length; j++) {
                        cases[k][i+lock.length - 1][j+lock.length - 1] = key[i][j];
                    }
                }
            } else if (k == 1) {
                for (int i = 0; i < key.length; i++) {
                    for (int j = 0; j < key.length; j++) {
                        cases[k][i+lock.length - 1][j+lock.length - 1] = key[key.length-1-j][i];
                    }
                }
            }
            else if (k == 2) {
                for (int i = 0; i < key.length; i++) {
                    for (int j = 0; j < key.length; j++) {
                        cases[k][i+lock.length - 1][j+lock.length - 1] = key[key.length-1-i][key.length-1-j];
                    }
                }
            }
            else if (k == 3) {
                for (int i = 0; i < key.length; i++) {
                    for (int j = 0; j < key.length; j++) {
                        cases[k][i+lock.length - 1][j+lock.length - 1] = key[j][key.length-1-i];
                    }
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < lock.length + (lock.length - 1); i++) {
                for (int j = 0; j < lock.length + (lock.length - 1); j++) {
                    boolean isAnswer = true;

                    for (int l = 0; l < lock.length; l++) {
                        for (int m = 0; m < lock.length; m++) {
                            if (cases[k][l+i][m+j] == lock[l][m]) {
                                isAnswer = false;
                                break;
                            }
                        }

                        if (!isAnswer) {
                            break;
                        }
                    }

                    if (isAnswer) {
                        return true;
                    }

                }
            }
        }

        return answer;
    }
}
