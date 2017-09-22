package Contest289;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassC {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        int firstB = scanner.nextInt();
        int prev = findMinInt(firstB, 1);
        buffer.append(prev).append('\n');
        int a;
        for (int i = 1; i < n; i++) {
            int b = scanner.nextInt();
            a = findMinInt(b, prev);
            buffer.append(a).append('\n');
            prev = a;
        }
        // 19 21 22
        // 10 3 4

        System.out.println(buffer.toString());
        scanner.close();
    }

    private static int findMinInt(int n, int moreThan) {
        if(moreThan < 10 && n < 10 && n > moreThan)
            return n;
        moreThan = Math.max(n, moreThan);
        int reminder = n % 9;
        int base = (moreThan / 9)*9;
        return base + reminder > moreThan ? base + reminder : base + reminder + 9;
    }
}
