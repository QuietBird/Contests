package contests.women3;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        
        class Point implements Comparable<Point>{
            int value;
            int inInterval;
            
            Point(int value, int inInterval){
                this.value = value;
                this.inInterval = inInterval;                
            }

            @Override
            public int compareTo(Point o) {
                return Integer.compare(this.value, o.value);
            }
        }
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] sizes = new int[n];
            for(int i=0; i < n; i++){
                sizes[i] = in.nextInt();
            }
            int v = in.nextInt();
            Point[] intervals = new Point[2*v];
            for(int a1 = 0; a1 < v; a1++){
                int smallest = in.nextInt();
                int largest = in.nextInt();
                intervals[2*a1] = new Point(smallest, 1);
                intervals[2*a1 + 1] = new Point(largest, -1);
            }
            Arrays.sort(intervals);
            int cntr = 0;
            for (int i = 0; i < 2 * v; i++) {
               Point pnt = intervals[i];
               cntr += pnt.inInterval;
               pnt.inInterval = cntr; 
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (Point pnt : intervals) {
                if(pnt.inInterval == 1 || pnt.inInterval == 0) {
                    map.put(pnt.value, pnt.inInterval);
                }
            }
            int counter = 0;
            for (int i = 0; i < n; i++) {
                int size = sizes[i];
                if(map.containsKey(size)) {
                    counter++;
                    continue;        
                }
                NavigableMap<Integer, Integer> subMap = map.headMap(size, false);
                if(subMap.isEmpty()) {
                    continue;
                }
                if(subMap.lastEntry().getValue() > 0) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
