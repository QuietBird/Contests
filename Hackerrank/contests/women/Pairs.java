package contests.women;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int max = Integer.MIN_VALUE;
            for (int a = 0; a < n; a++) {
                for (int b = a; b < n; b++) {
                    if((a & b) < k)
                        max = Math.max((a & b), max);
                }
            }
                    
            buffer.append(max).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
