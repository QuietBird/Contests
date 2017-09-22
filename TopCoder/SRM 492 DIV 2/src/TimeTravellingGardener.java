import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TimeTravellingGardener {
	
	public int determineUsage(int[] distance, int[] height) {
        int treesAmount = distance.length + 1;
        // y = (y2 - y1)/ (x2 - x1) * x + y1
        int[] coord = new int[treesAmount];
        System.arraycopy(distance, 0, coord, 1, distance.length);
        distance = coord;
        int max = 0;
		for(int i = 0; i < distance.length - 1; i++) {
            int x1 = distance[i];
            int y1 = height[i];
           label : for(int j = i + 1; j < distance.length; j++) {
                int x2 = distance[j];
                int y2 = height[j];
                int localMax = 0;
                for (int t = 0; t < distance.length; t++) {
                    int xi = distance[t];
                    int yi = height[t];

                    int diff = yi * (x2 - x1) - (y2 - y1) * xi - y1 * (x2 - x1);
                    if(diff < 0)
                        continue label;
                    if(diff == 0)
                        localMax++;
                }
                max = Math.max(max, localMax);
            }
        }
        return treesAmount - max;
	}
}
