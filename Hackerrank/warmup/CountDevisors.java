package warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CountDevisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String number = scanner.next();
            List<Integer> digits = getDigits(number);
            int innnt = Integer.parseInt(number);
            int counter = 0;
            for (Integer digit : digits) {
                if(digit == 0)
                    continue;
                if(innnt % digit == 0)
                    counter++;
            }
            buffer.append(counter).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }

    private static List<Integer> getDigits(String number) {
        List<Integer> digits = new ArrayList<>(number.length());
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '-')
                continue;
            digits.add(number.charAt(i) - 0x30);
        }
        return digits;
    }
}
