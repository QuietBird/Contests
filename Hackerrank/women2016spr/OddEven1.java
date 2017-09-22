package women2016spr;

import java.util.Scanner;

public class OddEven1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long evenD = 0;
        for (int i = 0; i < n; i++) {
            evenD += scanner.nextInt();
        }
        String result = evenD % 2 == 0 ? "Yes" : "No";
        result = result + " " + evenD;
        System.out.println(result);
        scanner.close();
    }
}
