package baekjoon.b_2002;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> in = new HashMap<>();

        for (int i = 0; i < n; i++) {
            in.put(sc.next(), i);
        }

        HashMap<String, Integer> rest = new HashMap<>();
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            Integer num = in.get(s);

            if (num == count.get()) {
//                System.out.println(num + " count.get() : " + count.get()  + " -- ");
                count.getAndIncrement();
            } else {
                AtomicBoolean flag = new AtomicBoolean(false);
                AtomicBoolean loopF = new AtomicBoolean(true);

//                System.out.println(count.get() + "==================");

                while (loopF.get()) {
                    AtomicBoolean loopM = new AtomicBoolean(false);
                    rest.forEach((k, v) -> {
                        if (v == count.get()) {
                            count.getAndIncrement();
//                            System.out.println(v + " -- check " + count.get());
                            flag.set(true);
                            loopM.set(true);
                        }
                    });

                    if (!loopM.get()) {
                        loopF.set(false);
                    }
                }

                if (num == count.get()) {
//                    System.out.println(num + " count.get() : " + count.get()  + " -- ");
                    count.getAndIncrement();
                } else {
//                    System.out.println(num + " -- rest");
                    rest.put(s, num);
                }
            }
        }

        System.out.println(rest.size());

    }
}
