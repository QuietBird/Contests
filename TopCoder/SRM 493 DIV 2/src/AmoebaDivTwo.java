import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class AmoebaDivTwo {
	
	public int count(String[] table, final int K) {
        int counter = 0;
        int localLength = K;
        if(K == 1) {
            for (int i = 0; i < table.length; i++) {
               for (int j = 0; j < table[0].length(); j++) {
                    if(table[i].charAt(j) == 'A')
                        counter++;

                }
            };
            return counter;
        }
        for (int i = 0; i < table.length; i++) {
            localLength = K;
            for (int j = 0; j < table[0].length(); j++) {
                if(table[i].charAt(j) == 'A') {
                    localLength--;
                    if(localLength <= 0)
                        counter++;
                } else {
                    localLength = K;
                }
            }
        };
        for (int j = 0; j < table[0].length(); j++) {
            localLength = K;
            for (int i = 0; i < table.length; i++) {
                if(table[i].charAt(j) == 'A') {
                    localLength--;
                    if(localLength <= 0)
                        counter++;
                } else {
                    localLength = K;
                }
            }
        };
        return counter;
	}
}
