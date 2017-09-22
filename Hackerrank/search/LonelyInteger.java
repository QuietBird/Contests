package search;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class LonelyInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            number ^= scanner.nextInt();;
        }
        System.out.println(number);
        scanner.close();
    }
}
