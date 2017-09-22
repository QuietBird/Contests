import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheShuttles {
	
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
        int result = Integer.MAX_VALUE;
        for (int shattlesSeats = 1; shattlesSeats < 101; shattlesSeats++) {
            int cost = 0;
            for (int emploees : cnt) {
                int shuttleNumber = emploees / shattlesSeats;
                if(emploees % shattlesSeats != 0)
                    shuttleNumber++;
                int localCost = (baseCost + shattlesSeats*seatCost)* shuttleNumber;
                cost += localCost;
            }
            result = Math.min(result, cost);
        }
        return result;
    }
}
