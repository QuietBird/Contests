package Contest294;

import java.util.Scanner;

public class ClassA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        // k > s && k < t
        String k = "No such string";
        boolean prevDiffers = false;
        for (int i = 0; i < s.length(); i++) {            
            char ct = t.charAt(i);
            char cs = s.charAt(i);
            if(!prevDiffers && (ct - cs < 2)) {
                prevDiffers = (ct > cs);
                continue;
            }    
            char ck = (char) (ct - 1);
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(i, ck);
            k = builder.toString();
            break;
        }
        scanner.close();
        System.out.println(k);
    }
}
