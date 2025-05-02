package programmers.유연근무제;

public class Main {
    public static void main(String[] args) {

        int answer = solution(new int[]{700, 800, 1100}, new int[][]{
                {710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        }, 5);

        System.out.println(answer);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        boolean[] late = new boolean[schedules.length];

        for (int i = 0; i < 7; i++) {
            if (startday == 6) {
                startday++;
                continue;
            } else if (startday == 7) {
                startday = 1;
                continue;
            }

            for (int j = 0; j < schedules.length; j++) {
                if (late[j]) {
                    continue;
                }

                int h = schedules[j] / 100;
                int m = schedules[j] % 100;

                m+=10;
                if (m >= 60) {
                    m-=60;
                    h++;
                }

                if ((h * 100 + m) < timelogs[j][i]) {
                    late[j] = true;
                }
            }

            startday++;
        }

        for (boolean b : late) {
            if (!b) {
                answer++;
            }
        }

        return answer;
    }
}
