package contests.w14;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int totalPages = scanner.nextInt();
            int alreadyHavePages = scanner.nextInt();
            int money = scanner.nextInt();
            int numberOfNotebooks = scanner.nextInt();
            int pagesNeeded = totalPages - alreadyHavePages;
            boolean canBuy = false;
            for (int j = 0; j < numberOfNotebooks; j++) {
                int numOfPages = scanner.nextInt();
                int price = scanner.nextInt();
                if (price <= money && numOfPages >= pagesNeeded) {
                    canBuy = true;
                    break;
                }
            }
            System.out.println(canBuy ? "LuckyChef" : "UnluckyChef");
        }
        scanner.close();
    }
}
