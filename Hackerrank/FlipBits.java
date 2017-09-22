import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class FlipBits {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int blackAmount = scanner.nextInt();
            int whiteAmount = scanner.nextInt();
            int blackCost = scanner.nextInt();
            int whiteCost = scanner.nextInt();
            int changeCost = scanner.nextInt();

            int moneyAmount = 0;

            if(changeCost < whiteCost && blackCost < whiteCost) {
                moneyAmount = (blackAmount + whiteAmount) * blackCost + whiteAmount * changeCost;
            } else if (changeCost < blackCost && whiteCost < blackCost) {
                moneyAmount = (blackAmount + whiteAmount) * whiteCost + blackAmount * changeCost;
            } else {
                moneyAmount = blackAmount*blackCost + whiteAmount*whiteCost;
            }

            buff.append(moneyAmount).append('\n');

        }
        System.out.println(buff.toString());

        scanner.close();
    }
}
