package contests.w13;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class FindAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            buffer.append(countAnagramPairs(string)).append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }

    private static int countAnagramPairs(String string) {
        int length = string.length();
        int counter = 0;
        for (int n = 1; n < length; n++) {
            for (int index = 0; index < length; index++) {
                if (index + n >= length)
                    break;
                HashMap<Character, Integer> map = countSubstringSumm(string, index, index + n);
                for (int i = length; i > index + n; i--) {
                    HashMap<Character, Integer> subMap = countSubstringSumm(string, i - n, i);
                    boolean anagramFound = map.equals(subMap);
                    if(anagramFound)
                        counter++;
                }
            }
        }
        return counter;
    }

    private static HashMap<Character, Integer> countSubstringSumm(String string, int leftIndex, int rightIndex) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = leftIndex; i < rightIndex; i++) {
            char key = string.charAt(i);
            Integer counter = result.get(key);
            if(counter == null)
                counter = 0;
            result.put(key, ++counter);
        }
        return result;
    }

    private static int countPalindromPairs2(String string) {
        int length = string.length();
        int counter = 0;
        for (int n = 1; n <= length / 2; n++) {
            for (int index = 0; index < length / 2; index++) {
                String substring = string.substring(index, index + n);
                String anagram = new StringBuilder(substring).reverse().toString();
                Pattern pattern = Pattern.compile(anagram);
                Matcher matcher = pattern.matcher(string);
                while(matcher.find())
                    counter++;
                if(substring.length() == 1)
                    counter--;
            }
        }
        return counter;

    }

    private static int countPalindromPairs(String string) {
        int length = string.length();
        int counter = 0;
        for (int n = 1; n <= length / 2; n++) {
            for (int index = 0; index <= length / 2; index++) {
                String substring = string.substring(index, index + n);
                for (int i = length - 1; i > index; i--) {
                    boolean anagramFound = true;
                    for (int j = 0; j < n; j++) {
                        if (substring.charAt(j) != string.charAt(i - j)) {
                            anagramFound = false;
                            break;
                        }
                    }
                    if(anagramFound)
                        counter++;
                }
            }
        }
        return counter;
    }
}
