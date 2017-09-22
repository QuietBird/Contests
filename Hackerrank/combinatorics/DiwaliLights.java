package combinatorics;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class DiwaliLights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long number = scanner.nextLong();
            // 2^n - 1
            long result = power(2, number, 100000) - 1;
            buffer.append(result).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
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
}
