package contests.w16_2016;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        int max = m + 1;
        int sqrtM = (int) Math.sqrt(max);
        int count = 0;
        BitSet nonPrime = new BitSet(max);
        final int MAX_PRIMES = 100_000;
        int[] primes = new int[MAX_PRIMES];
        int primesCount = 0;
        for (int i = 2; i <= sqrtM; i++) {
            if (!nonPrime.get(i)) {
                primes[primesCount++] = i;
                for (long j = i * (long)i; j <= sqrtM; j += i) {
                    nonPrime.set((int)j, true);
                }
            }
        }
        for (int i = 0; i < primesCount; i++) {
            int prime = primes[i];
            int closestLowerIndex = n / prime;
            if (closestLowerIndex < 2) {
                closestLowerIndex = 2;
            }
            for (int j = closestLowerIndex * prime; j < max; j += prime) {
                nonPrime.set(j, true);
            }
        }
        for (int i = n; i < max; i++) {
            if (!nonPrime.get(i) && (i > 1) && (i + 2 <= m) && !nonPrime.get(i + 2)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
