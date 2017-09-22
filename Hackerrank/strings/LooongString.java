package strings;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class LooongString {
    private static final int MODULO = 1000_006;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();
        scanner.close();
        int maxCharNumber = str.length();
        TreeMap<Character, Integer> char2amount = new TreeMap<>();
        for (Character c : str.toCharArray()) {
            Integer counter = char2amount.get(c);
            if(counter == null)
                counter = 0;
            char2amount.put(c, ++counter);
        }
        long counter = 1;

    }
}
