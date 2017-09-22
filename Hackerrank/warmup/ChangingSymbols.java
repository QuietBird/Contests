package warmup;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ChangingSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            char currentChar = string.charAt(0);
            int counter = 0;
            for (int j = 1; j < string.length(); j++) {
                if(string.charAt(j) != currentChar) {
                    currentChar = string.charAt(j);
                    continue;
                }
                counter++;
            }
            buffer.append(counter).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
