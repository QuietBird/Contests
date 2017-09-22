package women2016spr;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class SmitriAndStr5 {

    private static final char[] alphabetInv = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
            'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        
        for (int i = 0; i < tests; i++) {
            char[] next = scanner.next().toCharArray();
            int m = scanner.nextInt();

            StringBuilder tail = getStringBuilder(next, m);

            buffer.append(tail).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }

    public static StringBuilder getStringBuilder (char[] str, int m) {
        int toKeep = str.length - m;
        int[][] substrArr = new int[toKeep + 1][str.length + 1];
        int index = str.length - 1;
        char maxCh = str[index];
        for (int i = index; i >= 0 ; i--) {
            char ch = str[i];
            if(ch >= maxCh) {
                maxCh = ch;
                index = i;
            }
            substrArr[1][i] = index;
        }
        for (int j = 2; j <= toKeep; j++) {
            index = str.length - j;
            maxCh = str[index];

            for (int i = str.length - j; i >= 0; i--) {
                char ch = str[i];
                if(ch >= maxCh) {
                    maxCh = ch;
                    index = i;
                }
                substrArr[j][i] = index;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = toKeep; i > 0; i--) {
            index = substrArr[i][index];
            result.append(str[index]);
            index++;
        }
        return result;
    } 

}
