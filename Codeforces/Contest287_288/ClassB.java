package Contest287_288;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder builder = new StringBuilder(str);
        int maxIndex = -1;
        char lastDigit = str.charAt(str.length() - 1);
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if((c - '0') % 2 == 0) {
               if(c < lastDigit) {
                   maxIndex = i;
                   break;
               }
               maxIndex = i;
            }
        }
        if(maxIndex == -1) {
            System.out.println(-1);
            return;
        }
        char c = str.charAt(maxIndex);
        builder.setCharAt(maxIndex, lastDigit);
        builder.setCharAt(str.length() - 1, c);
        System.out.println(builder.toString());
        scanner.close();
    }
}
