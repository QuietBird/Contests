package Contest287_288;

import java.util.Scanner;

public class MoveCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double distance = Math.sqrt(((long)(x1 - x2)) * (x1 - x2) + ((long)(y1 - y2)) * (y1 - y2));

        scanner.close();
    }
}
