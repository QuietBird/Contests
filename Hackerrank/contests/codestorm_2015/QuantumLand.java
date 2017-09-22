package contests.codestorm_2015;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class QuantumLand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuffer buffer = new StringBuffer();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int a[] = new int[n + 1];
            int count = 0;
            int lastGuard = -1;
            for (int a_i = 1; a_i <= n; a_i++) {
                int value = in.nextInt();
                a[a_i] = value;
                if (value == 1) {
                    if (lastGuard < 0 && a_i > 1) {
                        count += a_i / 2;
                    } else {
                        int ff = a_i - lastGuard - 1;
                        if (ff > 1) {
                            count += ff / 2;
                        }

                    }
                    lastGuard = a_i;

                }
            }
            if (lastGuard != n && lastGuard != n - 1) {
                if (lastGuard < 0 && n > 1) {
                    count += n / 2;
                } else {
                    int ff = n - lastGuard;
                    if (ff > 1) {
                        count += ff / 2;
                    }

                }

            }

            buffer.append(count).append('\n');

        }
        System.out.println(buffer.toString());
    }
}

