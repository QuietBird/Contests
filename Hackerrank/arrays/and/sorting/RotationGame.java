package arrays.and.sorting;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class RotationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] belt = new int[n + 1];
        long pmean = 0;
        long summ = 0;
        for (int i = 1; i < n + 1; i++) {
            int next = scanner.nextInt();
            belt[i] = next;
            summ += next;
            pmean += i*((long)next);
        }
        long localPmean = pmean;
        for (int i = 1; i < n + 1; i++) {
            localPmean = localPmean - summ + belt[i] * (long)(n);
            pmean = Math.max(localPmean, pmean);
        }
        // 11 5 4 (33)-> 5 4 11 (46 = 33 + (- 5 - 4 - 11 + 33)) -> 4 11 5 (41)
        // 6 1 7
        System.out.println(pmean);
        scanner.close();
    }
}
