package contests.women;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Plants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        long N = scanner.nextLong();
        long oddHours = N / 2 + N % 2;
        long evenHours = N / 2;
        long resultTime = - (2 * time + 2 * (oddHours  - 1)) * oddHours / 2 + (2 * time + (evenHours  - 1)) * evenHours / 2;
        System.out.println(resultTime);
        scanner.close();
    }
}
