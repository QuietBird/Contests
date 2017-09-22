package warmup;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class LoveLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            int counter = 0;
            for (int j = 0; j < string.length() / 2; j++) {
                char c = string.charAt(j);
                char cEnd = string.charAt(string.length() - j - 1);
                if(c != cEnd)
                    counter += Math.abs(cEnd - c);

            }
            buffer.append(counter).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
