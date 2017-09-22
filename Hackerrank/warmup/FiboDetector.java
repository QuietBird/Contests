package warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class FiboDetector {
    private static final int MAX_LENGTH = 52;
    private static final long[] fibo = new long[MAX_LENGTH];
    static{
        fillFibos();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer results = new StringBuffer();

        for (int i = 0; i < n; i++) {
            long mayBe = scanner.nextLong();
            boolean isFibo = false;
            isFibo = Arrays.binarySearch(fibo, mayBe) >= 0;

            results.append(isFibo ? "IsFibo" : "IsNotFibo").append('\n');
        }
        System.out.println(results.toString());
        scanner.close();
    }

    private static void fillFibos() {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < MAX_LENGTH; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
    }
}
