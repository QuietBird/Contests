import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TypoCoderDiv2 {

	public int count(int[] rating) {
        int counter = 0;
        int startRating = 500;
        for (int i = 0; i < rating.length; i++) {
            int iRating = rating[i];
            if(iRating < 1200 && startRating >= 1200)
                counter++;
            if(iRating >= 1200 && startRating < 1200)
                counter++;
            startRating = iRating;
        }
        return counter;
	}
}
