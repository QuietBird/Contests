import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class IdentifyingWood {
	
	public String check(String s, String t) {
        boolean result = false;
        int index = 0;
        for(Character c : s.toCharArray()) {

            if(t.charAt(index) == c)
                index++;
            if(index >= t.length()) {
                result = true;
                break;
            }
        }
        return result ? "Yep, it's wood." : "Nope.";
	}
}
