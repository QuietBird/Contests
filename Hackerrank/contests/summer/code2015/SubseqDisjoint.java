package contests.summer.code2015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class SubseqDisjoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xxx = new int[n];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            xxx[i] = number;
        }
        scanner.close();
        long[][][] precalculated = new long[n+1][n+1][n+1];

        long maxSumm = Long.MIN_VALUE;
        for (int length = 1; length < n; length++) {
            for (int startX = 0; startX < n; startX++) {
                if (startX + length >= n)
                    break;
                for (int startY = 0; startY < n; startY++) {
                    if (startY + length > n)
                        break;
                    long prev = precalculated[length - 1][startX][startY + 1];
                    precalculated[length][startX][startY] = prev + (long) xxx[startX] * xxx[startY + length - 1];
                    long newV = precalculated[length][startX][startY];
                    System.err.println(length + " @ (" + startX +", " + startY + ") = value + " + prev + " = " + newV);
                    maxSumm = Math.max(maxSumm, newV);
                }

            }
        }
        System.out.println(maxSumm);
    }

}
