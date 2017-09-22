package contests.w28_2017;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int boats = scanner.nextInt();
        int maxPassengers = boats * capacity;
        boolean result = true;
        for (int i = 0; i < n; i++) {
            int pi = scanner.nextInt();
            if(pi > maxPassengers) {
                result = false;
                break;
            }
        }
        System.out.println(result ? "Yes" : "No");
        scanner.close();
    }
}
