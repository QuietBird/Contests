import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LuckyCounter {
	
	public int countLuckyMoments(String[] moments) {
        int result = 0;
		for(String str : moments) {
            char h1 = str.charAt(0);
            char h2 = str.charAt(1);
            char m1 = str.charAt(3);
            char m2 = str.charAt(4);
           if( (h1 == m1 && h2 == m2) || (h1== h2 && m1== m2) || ( h1 == m2 && h2 == m1) )
               result++;
        }
        return result;
	}
}
