package data_structures.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class QueueAlgorithms {

    public static String[] generateBinaryNumbers(int number) {
        String[] result = new String[number];
        Deque<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";

            queue.offer(n1);
            queue.offer(n2);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(generateBinaryNumbers(10)));

    }
}
