import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class VariableSpeedLimit {
	
	public double journeyTime(int journeyLength, int[] speedLimit) {
        double time = 0;
		while(journeyLength > 0) {
            for(int currentSpeed : speedLimit) {
                if(journeyLength > currentSpeed) {
                    journeyLength -= currentSpeed;
                    time++;
                } else {
                    return time + journeyLength * 1. / currentSpeed;
                }
            }
        }
        return time;
	}
}
