package euler.project;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class DecrypterABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] crypto = new char[n];
        for (int i = 0; i < n; i++) {
            crypto[i] = (char)scanner.nextShort();
        }
        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        char[] code = new char[3];
        for (char c : abc) {
            for (int i = 0; i < crypto.length; i++) {
                if((crypto[i] ^ c) == ' ')
                    code[i%3] = c;
            }
        }

        System.out.println(String.valueOf(code));
        scanner.close();
    }
}
