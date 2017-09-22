package bits;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CounterGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            BigInteger number = scanner.nextBigInteger();
            int counter = 1;
            BigInteger power = BigInteger.valueOf(1);
            power = power.shiftLeft(number.bitLength());
            while(number.compareTo(BigInteger.ONE) > 0) {
                power = power.shiftRight(1);
                BigInteger newNumber = number.subtract(power);
                if(newNumber.compareTo(BigInteger.ONE) < 0)
                    continue;
                number = newNumber;
                counter++;
            }
            buffer.append(counter % 2 == 1 ? "Richard" : "Louise").append('\n');
            // 7   6 8 10 11 12 13 15
            // 6  0110 4 + 1 Richard
            // 8 1000 4 + 2 + 1 Loise
            // 10 1010 8 + 1 Richard
            // 11 1011 8 + 2 Richard
            // 12 1100 8 + 2 + 1 Loise
            // 13 1110 8 + 4 Richard
            // 15 1111 8 + 4 + 2 Loise
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
}
