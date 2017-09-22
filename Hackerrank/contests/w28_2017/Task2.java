package contests.w28_2017;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            long number = scanner.nextLong();
            int position = 1;
            long variants = 0;
            while(number > 0) {
                if((number & 1) == 0) {
                    variants += (long)Math.pow(2, position - 1);
                }
                number = number >> 1;
                position++;
            }
            buffer.append(variants).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
