package Contest290;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        boolean fill = true;
        boolean right = true;
        for (int i = 0; i < n; i++) {
            if(fill) {
                for (int j = 0; j < m; j++) {
                    buffer.append('#');
                }
               fill = false;
            } else {
               if(!right)
                   buffer.append('#');
                for (int j = 0; j < m - 1; j++) {
                    buffer.append('.');
                }
                if(right)
                    buffer.append('#');
                right = !right;
               fill = true;
            }
            buffer.append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
