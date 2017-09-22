import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WinterAndMandarins {
	
	public int getNumber(int[] bags, int K) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(bags);
        for (int i = 0; i < bags.length; i++) {
            int offset = i + K - 1;
            if(offset >= bags.length)
                break;
            diff = Math.min(diff, Math.abs(bags[i] - bags[offset]));

        }
        return diff;
	}
}
