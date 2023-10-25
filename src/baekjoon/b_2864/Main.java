package baekjoon.b_2864;

import java.util.*;

// 5와 6사이
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String [] nums = new String[2];
        nums[0] = in.next();
        nums[1] = in.next();

        int Min, Max = 0;

        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < nums[a].length(); i++) {
                if (nums[a].charAt(i) == '6') {
                    nums[a] = nums[a].substring(0, i) + "5" + nums[a].substring(i + 1);
                }
            }
        }

        Min = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < nums[a].length(); i++) {
                if (nums[a].charAt(i) == '5') {
                    nums[a] = nums[a].substring(0, i) + "6" + nums[a].substring(i + 1);
                }
            }
        }

        Max = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

        System.out.println(Min + " " + Max);
    }
}