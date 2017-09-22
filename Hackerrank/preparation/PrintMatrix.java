package preparation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class PrintMatrix {
    
    public static void main(String[] args) {

        /*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();
        int shift = scan.nextInt();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                char start = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) (start + (((ch - start) + shift) % 26));
            }
            builder.append(ch);
        }
        System.out.println(builder.toString());*/
        char[] arr1 = { '!', '!', '!'};
        System.out.println(Arrays.toString(reverseString(arr1)));
    }
    
    private static char[] reverseString(char[] str) {
        if(str == null || str.length == 0) {
            throw new IllegalArgumentException();
        }
        int leftIndex = 0;
        // search last valid
        char ch = str[0];
        int rightIndex = 0;
        while (ch != '!') {
            rightIndex++;
            if(rightIndex >= str.length) {
                throw new IllegalArgumentException();
            }
            ch = str[rightIndex];
        }
        rightIndex--;

        while(leftIndex < rightIndex) {
            char temp = str[leftIndex];
            str[leftIndex] = str[rightIndex];
            str[rightIndex] = temp;
            rightIndex--;
            leftIndex++;
        }
        return str;
        // abc
    }
}
