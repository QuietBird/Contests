package Contest287_288;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Instruments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Instrument[] instruments = new Instrument[n];
        for (int i = 1; i <= n; i++) {
            instruments[i - 1] = new Instrument(i, scanner.nextInt());
        }
        scanner.close();
        Arrays.sort(instruments);
        StringBuilder builder = new StringBuilder();
        int summ = 0;
        int i = 0;
        while(i < n && (summ + instruments[i].days <= k)) {
            summ+= instruments[i].days;
            builder.append(instruments[i].number).append(' ');
            i++;
        }
        System.out.println(i);
        System.out.println(builder.toString());
    }

    static class Instrument implements Comparable<Instrument> {
        final int number;
        final int days;

        Instrument(int number, int days) {
            this.number = number;
            this.days = days;
        }

        @Override
        public int compareTo(Instrument o) {
            return Integer.compare(days, o.days);
        }
    }
}
