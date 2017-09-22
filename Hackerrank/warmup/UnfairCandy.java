package warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class UnfairCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = scanner.nextInt();
        }
        Arrays.sort(candies);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            min = Math.min(min, candies[i+k - 1] - candies[i]);
        }
        System.out.println(min);
        scanner.close();
    }
}
