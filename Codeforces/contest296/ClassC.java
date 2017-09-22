package contest296;

import java.util.Scanner;

public class ClassC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        System.out.println(count(n, m));
    }
    
    private static int count(int n, int m) {
        int counter = 0;
        while(true) {
            if (m == 0 || n == 0) {
                return counter;
            }
            if (m == 1 && n == 1) {
                return counter;
            }
            if (m == 2 && n == 2) {
                return counter + 1;
            }
            if (n >= m * 2) {
                return counter + m;
            }
            if (m >= n * 2) {
                return counter + n;
            }
            int max = Math.max(n, m);
            int min = Math.min(n, m);
            int thirdMax = max / 3;
            counter += thirdMax;
            n = min - thirdMax;
            m = max - 2 * thirdMax;
        }
    }
}
