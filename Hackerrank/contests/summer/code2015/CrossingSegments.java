package contests.summer.code2015;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CrossingSegments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> tail = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            SortedMap<Integer, Integer> tailMap = tail.tailMap(x2);
            for (Map.Entry<Integer, Integer> entry : tailMap.entrySet()) {
                if(entry.getValue() <= x1) {
                    tail.remove(entry.getKey());
                    break;
                }
            }
            boolean overlaps = false;
            SortedMap<Integer, Integer> headMap = tail.headMap(x2);
            for (Map.Entry<Integer, Integer> entry : headMap.entrySet()) {
                if(entry.getValue() >= x1) {
                    overlaps = true;
                    break;
                }
            }
            if(!overlaps )
                tail.put(x2, x1);
        }

        System.out.println(tail.size());
        scanner.close();
    }
}
