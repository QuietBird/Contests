package warmup;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class GOF1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] letters = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int letterIndex = str.charAt(i) - 'a';
            letters[letterIndex] += 1;
        }
        boolean isOdd = false;
        String result = "YES";
        for (int letter : letters) {
            if(letter % 2 == 0)
                continue;
            if(isOdd) {
                result = "NO";
                break;
            }
            isOdd = true;
        }
        System.out.println(result);
        scanner.close();
    }
}
