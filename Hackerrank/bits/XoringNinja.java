package bits;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class XoringNinja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < testNumber; i++) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            // 1 2 3  1^2 + 2
            buffer.append(1).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
