package contests.w72;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            set.add(p);
            arr[i] = p;
            if(i > 0 && arr[i - 1] > p)
                sorted = false;
        }
        scanner.close();
        if(sorted) {
            System.out.println(String.format("%.6f", 0.));
            return;
        }
            
        double p = 0;
        /*if(set.size() == n) {
            p = 1.
        }
        n*q^(n-1)*p
        System.out.println(buffer.toString());*/
        
    }
}
