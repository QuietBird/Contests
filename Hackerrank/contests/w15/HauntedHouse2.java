package contests.w15;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class HauntedHouse2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[300005];
        for (int i = 0; i < n; i++) {
            int peopleNeeded = scanner.nextInt();
            int noMoreThan = scanner.nextInt();
            array[peopleNeeded] += 1;
            array[noMoreThan] -= 1;
        }
        int counter = 0;
        int localCounter = 0;
        int people = 0;
        for (int i = 0; i < n; i++) {
            people += array[i];
            if(people > 0)
                localCounter++;
            else
                localCounter = 0;
            counter = Math.max(counter, localCounter);
        }
        System.out.println(counter);
        scanner.close();
    }
}
