package contests.w72;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long max = 0;
        long impMax = 0;
        List<Integer> impList = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            int luck = scanner.nextInt();
            int important = scanner.nextInt();
            if(important == 0) {
                max += luck;
            } else {
                impList.add(luck);
                impMax += luck;
            }
        }
        long result = 0;
        int size = impList.size();
        if (k < size) {
            Collections.sort(impList);
            for (int i = 0; i < size - k; i++) {
                impMax -= 2*impList.get(i);
            }
            result = max + impMax;
        } else {
            result = max - impMax;
        }    
        System.out.println(result);
        scanner.close();
    }
}



