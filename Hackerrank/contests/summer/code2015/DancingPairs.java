package contests.summer.code2015;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class DancingPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int heightDelta = scanner.nextInt();
        PriorityQueue<Integer> boys = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            boys.add(scanner.nextInt());
        }
        PriorityQueue<Integer> girls = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            girls.add(scanner.nextInt());
        }
        scanner.close();
        int counter = 0;
        while (!boys.isEmpty() && !girls.isEmpty()) {
            int nextBoy = boys.peek();
            int nextGirl = girls.peek();
            if(Math.abs(nextBoy - nextGirl) <= heightDelta) {
                boys.poll();
                girls.poll();
                counter++;
            } else {
                if (nextBoy > nextGirl) {
                    girls.poll();
                } else {
                    boys.poll();
                }
            }
        }
        System.out.println(counter);
    }
}
