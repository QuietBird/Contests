package women2016spr;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ConsonantReversal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] next = scanner.next().toCharArray();
            int start = 0;
            int end = next.length - 1;
            while (start < end) {
                char startCh = next[start];
                char endCh = next[end];
                if(isVovel(startCh)) {
                    start++;
                    continue;
                }
                if (isVovel(endCh)) {
                    end--;
                    continue;
                }
                next[start] = endCh;
                next[end] = startCh;
                end--;
                start++;
            }
            buffer.append(next).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
    
    private static boolean isVovel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o';        
    }
}
