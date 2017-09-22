package warmup.impl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CutTheSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sticks = new int[n];
        for (int i = 0; i < n; i++) {
            sticks[i] = scanner.nextInt();
        }
        Arrays.sort(sticks);
        int stick = sticks[0];
        int counter = 1;
        System.out.println(n);
        // 2 2 4 4 5 8
        // 2 2 3 6
        // 1 4
        // 3
        for (int i = 1; i < n; i++) {
            if(stick == sticks[i]) {
                counter++;
                continue;
            }
            System.out.println(n - counter);
            stick = sticks[i];
            n -= counter;
            counter = 1;
        }
        System.out.println(counter);
        scanner.close();
    }
}
