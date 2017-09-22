package Contest292;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class ClassB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        int result = n;
        Set<Point> enemiesLocations = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean add = enemiesLocations.add(new Point(x, y));
            if(!add)
                result--;
        }
        Point[] points = enemiesLocations.toArray(new Point[enemiesLocations.size()]);
        boolean[] destroyed = new boolean[enemiesLocations.size()];
        for (int i = 0; i < points.length; i++) {
            Point point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                if(destroyed[j])
                    continue;
                Point point2 = points[j];
                if((point1.x * (y0 - point2.y) + x0 * (point2.y - point1.y) + point2.x * (point1.y - y0)) == 0) {
                    destroyed[j] = true;
                    result--;
                }
                    
            }
            destroyed[i] = true;
        }
        System.out.println(result);
        scanner.close();
    }
}
