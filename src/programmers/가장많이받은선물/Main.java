package programmers.가장많이받은선물;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] a = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        String[] b = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        System.out.println(solution(a, b));
    }

    public static int solution(String[] friends, String[] gifts) {
        int[][] 아파트 = new int[friends.length][friends.length];
        int[] 선물지수 = new int[friends.length];
        int[] 예상선물 = new int[friends.length];

        for (int i = 0; i < gifts.length; i++) {
            String 선물준사람이름 = gifts[i].split(" ")[0];
            String 선물받은사람이름 = gifts[i].split(" ")[1];
            int 선물준사람 = Arrays.asList(friends).indexOf(선물준사람이름);
            int 선물받은사람 = Arrays.asList(friends).indexOf(선물받은사람이름);

            아파트[선물준사람][선물받은사람]++;
        }

        for (int i = 0; i < friends.length; i++) {

            int 준선물 = 0;
            int 받은선물 = 0;

            for (int j = 0; j < friends.length; j++) {
                준선물 += 아파트[i][j];
            }

            for (int j = 0; j < friends.length; j++) {
                받은선물 += 아파트[j][i];
            }

            선물지수[i] = 준선물 - 받은선물;
        }

        for (int i = 0; i < friends.length; i++) {

            for (int j = 0; j < friends.length; j++) {

                if(i == j) continue;

                if ((아파트[i][j] != 0 || 아파트[j][i] != 0) && 아파트[i][j] > 아파트[j][i]) {
                    예상선물[i]++;
                } else if (아파트[i][j] == 아파트[j][i]) {
                    if (선물지수[i] > 선물지수[j]) {
                        예상선물[i]++;
                    }
                }

            }

        }

        int max = 예상선물[0];

        for (int j : 예상선물) {
            if (max < j) {
                max = j;
            }
        }

        return max;
    }

}
