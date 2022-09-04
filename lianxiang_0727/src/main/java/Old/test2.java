package Old;

import java.util.PriorityQueue;

public class test2 {

    public static void main(String[] args) {

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
