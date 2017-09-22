package contests.women2;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] prices = new long[n];
        
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();            
        }        
        scanner.close();
        long min = Long.MIN_VALUE;
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = n - 1; i >= 0 ; i--) {
            long price = prices[i];
            Long lower = tree.lower(price);
            if(lower == null) {
                tree.add(price);
                continue;
            }
            
            long closest = lower;
            if(closest - price > min) {
                min = closest - price;
            }
            tree.add(price);
            
        }
        System.out.println(-min);
    }
}
