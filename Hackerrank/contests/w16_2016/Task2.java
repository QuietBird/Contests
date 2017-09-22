package contests.w16_2016;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= n ; i++) {
            if(n % i == 0) {
                divisors.add(i);
            }
        }
        TreeMap<Integer, Integer> summs = new TreeMap<>();
        for (Integer divisor : divisors) {
            int div = divisor;
            int sum = countDigitsSum(div);
            Integer previosDivider = summs.get(sum);
            if(previosDivider != null && previosDivider < divisor)
                continue;
            summs.put(sum, divisor);
        }

        System.out.println(summs.lastEntry().getValue());
        scanner.close();
    }

    public static int countDigitsSum(int div) {
        int sum = 0;
        while (div > 0) {
            sum += div % 10;
            div /= 10;
        }
        return sum;
    }
}
