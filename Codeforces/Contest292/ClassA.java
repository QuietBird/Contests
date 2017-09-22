package Contest292;

import java.util.Scanner;

public class ClassA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long pow10 = 10;
        while(pow10 < n)
            pow10 *= 10;
        pow10 /= 10;
        long firstDigit = n / pow10;
        long summ = firstDigit == 9 ? 9 * pow10 : (9 - firstDigit > firstDigit ? firstDigit : 9 - firstDigit) * pow10;
        n -= firstDigit * pow10;
        pow10 /= 10;
        while (n > 10) {
            firstDigit = n / pow10;
           summ += 9 - firstDigit > firstDigit ? firstDigit * pow10 : (9 - firstDigit)*pow10;
            n -= firstDigit * pow10;
            pow10 /= 10;
        }
        summ += 9 - n > n ? n : 9 - n;
        System.out.println(Long.toString(summ));
        scanner.close();
    }
}
