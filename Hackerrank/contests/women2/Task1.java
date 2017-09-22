package contests.women2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] keyboard = new int[n];
        int[] usb = new int[m];

        for (int i = 0; i < n; i++) {
            keyboard[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            usb[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(keyboard);
        Arrays.sort(usb);
        if(usb[0] + keyboard[0] > s) {
            System.out.println(-1);
            return;
        }
        long max = 0;
        long summ = 0;
        for (int i = n - 1; i >= 0; i--) {
            int kb = keyboard[i];
            for (int j = 0; j < m; j++) {
                int usbb = usb[j];
                summ = kb + usbb;
                if(summ > s)
                    break;
                if(summ > max)
                    max = summ;
            }
        }
        System.out.println(max);
        
    }
}
