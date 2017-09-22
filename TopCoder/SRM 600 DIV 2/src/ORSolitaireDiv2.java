import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ORSolitaireDiv2 {
	
	public int getMinimum(int[] numbers, int goal) {
        int[] goalBits = new int[32];
        for (int i = 0; i < 32; i++) {
            goalBits[i] = (goal >> i & 1) == 1 ? 1 : 0;
        }
        int[] counter = new int[32];
		for(int number : numbers) {
            if((number | goal) != goal)
                continue;
            for (int i = 0; i < 32; i++) {
                int bit = (number >> i & 1) == 1 ? 1 : 0;
                if(goalBits[i] == bit)
                    counter[i] = counter[i] + 1;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i : counter) {
            result = Math.min(result, i);
        }
        return result;
	}
}
