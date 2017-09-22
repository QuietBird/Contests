package contests.women2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            long n = scanner.nextLong();
            int m = scanner.nextInt();
            long[] factors = new long[m];
            for (int j = 0; j < m; j++) {
                factors[j] = scanner.nextLong();
            }
            Arrays.sort(factors);
            HashMap<Long, Long> results = new HashMap<>();

            System.out.println(recursiveMax(n, m, factors, results));
        }

        scanner.close();
    }

    private static long recursiveMax(long n, int m, long[] factors, HashMap<Long, Long> results) {
        long max = 0;
        for (int j = 0; j < m; j++) {
            long factor = factors[j];
            if(n % factor != 0)
                continue;
            if(n == factor)
                continue;

            long diminder = n / factor;
            
            Long factResult = results.get(factor);
            long localResult;
            if(factResult == null) {
                localResult = recursiveMax(factor, m, factors, results);
            } else {
                localResult = factResult;
            }
            localResult = diminder * localResult + 1;
            if(localResult> max) {
                max = localResult;
            }
        }
        results.put(n, max);
        return max;
    }
}
