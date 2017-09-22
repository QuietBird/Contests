import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BlackBoxDiv2 {
	
	public int count(String front, String side) {
        int clearColumn = 0;
        int width = front.length();
        for (int i = 0; i < width; i++) {
            if(front.charAt(i) == '.')
                clearColumn++;
        }
        int clearRow = 0;
        int height = side.length();
        for (int i = 0; i < height; i++) {
            if(side.charAt(i) == '.')
                clearRow++;
        }
        int blackColumn = width - clearColumn;
        int blackRow = height - clearRow;
		int ambigCell = width * height - clearColumn*width - clearRow*height;
        return (2 << ambigCell) - (2 << (blackColumn + blackRow));
    }
}
