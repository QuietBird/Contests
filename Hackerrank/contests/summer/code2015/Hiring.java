package contests.summer.code2015;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Hiring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long patience = scanner.nextLong();
        int patienceDecr = scanner.nextInt();
        long rank = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long number = scanner.nextLong();
            rank = Math.max(rank, number * patience);
            patience -= patienceDecr;
        }
        System.out.println(rank);
        scanner.close();
    }
    
}
