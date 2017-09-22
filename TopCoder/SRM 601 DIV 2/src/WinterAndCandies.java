import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WinterAndCandies {
	
	public int getNumber(int[] type) {
        int length = type.length;
        int[] count = new int[length];
        for (int t : type) {
            if (t < 1 || t > length)
                continue;
            count[t-1]++;
        }
        int result = 0;
        int current = 1;
        // 1,1,1 2,2,2,2 3,3,3,3,3 5
        for (int k = 1; k <= length ; k++) {
            current = current * count[k - 1];
            result += current;
        }
        return result;
	}
}
