package Contest286;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < str.length(); i++) {
            for (char c : alphabet) {
                StringBuilder builder = new StringBuilder(str);
                builder.insert(i, c);
                String s = builder.toString();
                if(isPalindrome(s)) {
                    System.out.println(s);
                    return;
                }
            }
        }
        String lastChance = new StringBuilder(str).append(str.charAt(0)).toString();
        if(isPalindrome(lastChance)) {
            System.out.println(lastChance);
            return;
        }
        System.out.println("NA");
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
