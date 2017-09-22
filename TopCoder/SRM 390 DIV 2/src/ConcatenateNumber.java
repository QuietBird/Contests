import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ConcatenateNumber {

    public int getSmallest(int number, int k) {
        long p10 = 1;
        while (p10 <= number)
            p10 *= 10;

        long current = number % k;
        for (int i = 1; i <= k; ++i) {
            if (current == 0) {
                return i;
            }
            current = (current * p10 + number) % k;
        }
        return -1;
    }
}
