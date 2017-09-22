import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WinterAndReindeers {
	
	public int getNumber(String[] allA, String[] allB, String[] allC) {
        List<String> matchA = new ArrayList<String>();
        List<String> matchB = new ArrayList<String>();
        int counter = 0;
        for(String c : allC) {
            for(String a : allA) {
                if(isSubsequence(a, c))
                    matchA.add(a);
            }
            if(matchA.isEmpty())
                continue;
            for(String b : allB) {
                if(isSubsequence(b, c))
                    matchB.add(b);
            }
            if(matchB.isEmpty()) {
                matchA.clear();
                continue;
            }
        }
		return counter;
	}

    private boolean isSubsequence(String a, String c) {
        return false;
    }
}
