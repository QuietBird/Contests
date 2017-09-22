package contests.summer.code2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Substrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long result = 0;
        char[] frase = scanner.next().toCharArray();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        Map<Character, Integer> countChars = new HashMap<>();
        for (char c : alphabet) {
            countChars.put(c, 0);
        }
        for (int i = 0; i < n; i++) {
            char c = frase[i];
            Integer counter = countChars.get(c);
            result += counter;
            result++;
            countChars.put(c, counter + 1);
        }
        System.out.println(result);
        scanner.close();
    }
}
