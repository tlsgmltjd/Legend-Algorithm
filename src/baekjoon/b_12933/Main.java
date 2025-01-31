package baekjoon.b_12933;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int dup = 0;
        List<Queue<Character>> queue = new ArrayList();

        int max = -1;

        for (int i = 0; i < N.length(); i++) {
            char sound = N.charAt(i);

            switch (sound) {
                case 'q': {
                    dup++;

                    ArrayDeque<Character> newQueue = new ArrayDeque<>();
                    newQueue.add(sound);
                    queue.add(newQueue);

                    break;
                }
                case 'u': {

                    boolean temp = false;

                    for (Queue<Character> characters : queue) {
                        if (characters.size() == 1) {
                            characters.add(sound);
                            temp = true;
                            break;
                        }
                    }

                    if (!temp) {
                        System.out.println(-1);
                        return;
                    }

                    break;
                }
                case 'a': {

                    boolean temp = false;

                    for (Queue<Character> characters : queue) {
                        if (characters.size() == 2) {
                            characters.add(sound);
                            temp = true;
                            break;
                        }
                    }

                    if (!temp) {
                        System.out.println(-1);
                        return;
                    }

                    break;
                }
                case 'c': {

                    boolean temp = false;

                    for (Queue<Character> characters : queue) {
                        if (characters.size() == 3) {
                            characters.add(sound);
                            temp = true;
                            break;
                        }
                    }

                    if (!temp) {
                        System.out.println(-1);
                        return;
                    }

                    break;
                }
                case 'k': {
                    dup--;

                    boolean temp = false;

                    for (Queue<Character> characters : queue) {
                        if (characters.size() == 4) {
                            characters.add(sound);
                            temp = true;
                            break;
                        }
                    }

                    if (!temp) {
                        System.out.println(-1);
                        return;
                    }

                    break;

                }
            }

            max = Math.max(max, dup);

        }

        for (Queue<Character> characters : queue) {
            if (characters.size() != 5) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(max);

    }
}
