package programmers.멋쟁이숫자;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int loop = s.length() - 2;

        int max = -1;

        for (int i = 0; i < loop; i++) {
            String v = s.substring(i, 3 + i);
            if (v.charAt(0) == v.charAt(1) && v.charAt(1) == v.charAt(2)) {
                max = Math.max(max, Integer.parseInt(v.charAt(0) + ""));
            }
        }

        System.out.println(max == -1 ? max : "" + max + max + max);

    }
}