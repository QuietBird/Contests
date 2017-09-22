package contest296;

import java.util.*;

public class ClassD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] charPrice = new int[26];
        for (int i = 0; i < 26; i++) {
            charPrice[i] = scan.nextInt();
        }
        String str = scan.next();
        scan.close();
        Map<Character, List<Integer>> occurMap = new HashMap<>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (char c : alphabet) {
            occurMap.put(c, new ArrayList<Integer>(2));
        }
        long summ = 0;
        long[] summs = new long[str.length()];
        int[] sameChars = new int[str.length()]; 
        int countInteresting = 0;
        for (int i = 0; i < str.length(); ) {
            char c = str.charAt(i);            
            int cPrice = charPrice[c - 'a'];
            int charCounter = 1;
            List<Integer> integers = occurMap.get(c);

            while(str.charAt(i) == c) {                
                summs[i] = summ;
                summ += cPrice;
                integers.add(i);
                sameChars[i] = charCounter;
                charCounter++;
                i++;
            }
            
        }
        
        for (Character ch : occurMap.keySet()) {
            List<Integer> integers = occurMap.get(ch);
            if(integers.isEmpty() || integers.size() == 1)
                continue;
            for (int i = integers.size() - 1; i > 0; i--) {
                int secondOccur = integers.get(i);
                int j = i - sameChars[secondOccur];
                if(sameChars[secondOccur] > 1) {
                    if(charPrice[ch - 'a'] == 0) {
                        countInteresting++;
                    } else {
                        countInteresting += sameChars[secondOccur] - 1;
                    }
                }
                for (; j >= 0; j--) {
                    int firstOccur = integers.get(j);
                    if(summs[secondOccur] - summs[firstOccur + 1] == 0)
                        countInteresting++;
                }
            }
        }
        System.out.println(countInteresting);
    }
}
