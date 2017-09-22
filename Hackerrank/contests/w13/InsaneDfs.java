package contests.w13;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class InsaneDfs {
    private static final int MODULO = 1000_000_007;
    private static final long[] CATALAN = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] depths = new int[n];
        int lastKnownNumber = 0;
        int unknownCounter = 0;
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            boolean unknown = "?".equals(string);
            if(unknown) {
                if(i==0) {
                    depths[i] = 0;
                    continue;
                }
                if(i==1) {
                    depths[i] = 1;
                    continue;
                }
                depths[i] = -1;
                unknownCounter++;
                continue;
            }
            int number = Integer.parseInt(string);
            if((i == 0 && number != 0) || (number == 0 && i!= 0)) {
                System.out.println(0);
                return;
            }
            if(number > 1 ) {
                if(number > (lastKnownNumber + unknownCounter + 1)) {
                    System.out.println(0);
                    return;
                }
                if(unknownCounter > 0) {
                    for (int j = 1; j <= unknownCounter; j++) {
                       depths[i - j] = number - j;
                    }
                }
            }

            depths[i] = number;
            lastKnownNumber = number;
            unknownCounter = 0;
        }
        scanner.close();
        System.out.println(countVariants(depths));
    }

    // 6     0 1 ? ? ? 5
    // 5   0 1 ? ? ? (1, 1, 1) (1, 2, 1) (1, 2, 2) (1, 1, 2) (1, 2, 3 ) (2, 1, 1) (2, 1, 2) (2, 2, 1) (2, 2, 2) (2, 3, 1) (2, 3, 2) (2, 3, 3) (2, 3, 4)
    //         1 2 3 4

    // 0 1 2 ? ? (1, 1) (1, 2) (2, 1) (2, 2) (2, 3)

    private static long countVariants(int[] depths) {
        long counter = 0;
        int localUnknown = 0;
        int lastKnownValue = 0;
        for (int depth : depths) {
            if (depth == -1) {
                localUnknown++;
                continue;
            }
            if (localUnknown == 0) {
                lastKnownValue = depth;
                continue;
            }
            counter = addition(counter, countVariants(localUnknown, lastKnownValue), MODULO);
            localUnknown = 0;
            lastKnownValue = depth;
        }
        counter = addition(counter, countVariants(localUnknown, lastKnownValue), MODULO);
        return Math.max(counter, 1);
    }

    private static long countVariants(int localUnknown, int lastKnownValue) {
        return catalanNumber(localUnknown + 1, MODULO);
    }

    private static long addition(long a, long b, long modulo) {
        if (modulo - a < b)
            return ((((a >> 1) + (b >> 1)) % (modulo >> 1)) << 1) + (a & 1) + (b & 1) - (modulo & 1);
        return (a + b) % modulo;
    }

    private static long multiplication (long a, long b, long modulo) {
        long remainder = 0;
        while (b > 0) {
            if ((b & 1) > 0) {
                remainder = addition(a, remainder, modulo);
            }
            a = addition(a, a, modulo);
            b >>= 1;
        }
        return remainder;
    }

    private static long power(long a, long b, long modulo) {
        long remainder = 1;
        if (b <= 0) return -1;
        while (b > 0) {
            if ((b & 1) > 0) remainder = multiplication(a, remainder, modulo);
            a = multiplication(a, a, modulo);
            b >>= 1;
        }
        return remainder;
    }

    private static long catalanNumber(int n, long modulo) {
        if(n < CATALAN.length)
            return CATALAN[n] % modulo;
        if (n == 0)
            return 1;
        long result = 0;
        for (int i = 0; i < n; i++) {
           result = addition(result, multiplication(catalanNumber(i, modulo), catalanNumber(n - i - 1, modulo), modulo), modulo);
        }
        return result;
    }
}

// 0 1 ? ? ?