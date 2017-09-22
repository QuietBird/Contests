import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TimeTravellingCellar {
	
	public int determineProfit(int[] profit, int[] decay) {
        int max = 0;

		for(int i = 0; i < profit.length; i++) {
            int prof = profit[i];
            for(int j = 0; j < profit.length; j++) {
                if(j == i)
                    continue;
                max = Math.max(max, prof - decay[j]);
            }
        }
        return max;
	}
}
