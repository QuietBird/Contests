package contests.w16_2016;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result = 0;
        if(n != 1 && m != 1) {
           result = (n * m) / 4; 
           if(n % 2 == 1 && m % 2 ==1) {
               result += (m + 1) / 2 + n / 2;
           } else if (n % 2 == 1) {
               result += m / 2;
           } else if (m % 2 == 1) {
               result += n / 2;
           }
            
        } else if (n == 1) {
           result = (m + 1) / 2;  
        } else {
            result = (n + 1) / 2;
        }
        
        System.out.println(result);
        scanner.close();
    }
}



