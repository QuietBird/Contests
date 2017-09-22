import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FingerCounting {
	
	public int maxNumber(int weakFinger, int maxCount) {
        int largest = 0;
        int[] fingers = {1, 2, 3, 4, 5, 4, 3, 2};
        while(maxCount >= 0) {
            for (int finger : fingers) {
                if(finger == weakFinger) {
                    if(maxCount == 0)
                        return largest;
                    maxCount--;
                }
                largest++;
            }
        }
        return largest;
    }

}
