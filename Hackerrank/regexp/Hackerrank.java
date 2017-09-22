package regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Hackerrank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        scan.nextLine();
        StringBuilder strBuff = new StringBuilder();
        Pattern hackStart = Pattern.compile("^hackerrank");
        Pattern hackEnd = Pattern.compile("hackerrank$");
        for(int i = 0; i < tests; i++) {
            String str = scan.nextLine();
            Matcher matcherStart = hackStart.matcher(str);
            Matcher matcherEnd = hackEnd.matcher(str);
            boolean atStart = matcherStart.find();
            boolean atEnd = matcherEnd.find();
            int result = -1;
            if(atEnd && atStart) {
                result = 0;
            } else if(atStart) {
                result = 1;
            } else if(atEnd) {
                result = 2;
            }
            strBuff.append(result).append('\n');
        }
        scan.close();
        System.out.println(strBuff.toString());
    }
}
