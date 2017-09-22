package warmup;

import java.util.List;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int years = scanner.nextInt();
            long height = 1;
            for (int j = 1; j < years + 1; j++) {
                if(j % 2 == 0) {
                    height++;
                } else {
                    height *= 2;
                }

            }
            buffer.append(height).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
