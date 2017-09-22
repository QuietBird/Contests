import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class QuadraticLaw {
	
	public long getTime(long d) {
        if(d <= 1)
            return 0L;
        long a = 4 * d + 1;
        double pow = (-1 + Math.pow(a, 0.5))/ 2;
        return (long)Math.floor(pow);
	}
}
