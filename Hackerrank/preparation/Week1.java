package preparation;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Week1 {
    public static void main(String[] args) {
       /*int[][] arr = generate1234Matrix(1000);
       for(int[] a : arr) {
           System.out.println(Arrays.toString(a));
       }
        System.out.println("Random calls:" + calls);*/
       /* int[] arr = {1, 2,3 ,4,5,-6};
        System.out.println(minimumumInK(arr, 5));*/
        HashSet<String> set = new HashSet<>();
        String[] strings = {"aaa", "cdf", "too", "hgfdt", "paa"};
        set.addAll(Arrays.asList(strings));
        patternMatch("xxx" , set);
    }
    
    /**
     * Random generate a NxN matrix with only four types of element: 1,2,3,4.
     However, no column or row can have same type of element appears 3 times or above continuously
     (three same type of elements are connected)

     ex:

     valid:
     1 2 1 1
     3 1 4 2
     1 2 4 2
     3 1 2 3

     invalid because the first column has element 1 appears three times and all 1s are connected to each other :

     1 2 1 3
     1 3 4 2
     1 2 4 4
     2 3 2 2 
     */
    
    private static int[][] generate1234Matrix(int n) {
       int[][] result = new int[n][n];
       int[] digits = {1, 2, 3, 4};
       Random random = new Random();
        
       LinkedList list = new LinkedList();
       for(int i = 0; i < n; i++) {
           for(int j = 0; j < n; j++ ) {
//               System.err.println(i + " " + j);
               int candidate = digits[callRandom(digits, random)];
               int doubledPreviousInColumn = -1;
               int doubledPreviousInRow = -1;
               if (j >= 2 && (result[i][j - 1] == result[i][j - 2])) {
                   doubledPreviousInRow = result[i][j - 1];
               }
               if (i >= 2 && (result[i - 1][j] == result[i - 2][j])) {
                   doubledPreviousInColumn = result[i - 1][j];
               }
               while (candidate == doubledPreviousInColumn || candidate == doubledPreviousInRow) {
                   candidate = digits[callRandom(digits, random)];
               }
               result[i][j] = candidate;
           }
       }
       return result; 
    }

    private static int calls = 0;
    
    private static int callRandom(int[] digits, Random random) {
        calls++;
        return random.nextInt(digits.length);
    }
    
    /*You are given a sorted list of distinct integers from 0 to 99,
    for instance [0, 1, 2, 50, 52, 75].
    Your task is to produce a string that describes numbers missing from the list;
    in this case "3-49,51,53-74,76-99".

    Examples:

    [] “0-99”
    [0] “1-99”
    [3, 5] “0-2,4,6-99”
    */

    private static String missingNumbers(int[] array) {
        int leftSkipped = 0;
        int rightSkipped = 99;

        StringBuilder builder = new StringBuilder();



        for(int i = 0;i < array.length; i++) {
            int a = array[i];
            if (a == leftSkipped) {
                leftSkipped++;
            } else {
                if(builder.length() > 0) {
                    builder.append(", ");
                }
                builder.append(leftSkipped);
                if (a - leftSkipped > 1) {
                    builder.append('-').append(a - 1);
                }
                leftSkipped = a + 1;
            }

        }
        if(leftSkipped <= rightSkipped) {
            if(builder.length() > 0) {
                builder.append(", ");
            }
            if(leftSkipped == rightSkipped) {
                builder.append(leftSkipped);
            } else {
                builder.append(leftSkipped).append('-').append(rightSkipped);
            }
        }
        return builder.toString();
    }
    
    /*Find the minimum of every contagious sub-array of size k in an array of size n.*/
    private static long minimumumInK(int[] array, int k) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (k > array.length) {
            throw new IllegalArgumentException();
        }
        long min = 0;
        for (int i = 0; i < k; i++) {
            min += array[i];
        }
        int shift = 0;
        long localSumm = min;
        while(shift + k < array.length) {
            localSumm = localSumm - array[shift] + array[k + shift];
            if(localSumm < min) {
                min = localSumm;
            }
            shift++;
        }
        return min;
                
    }
    
    /*Given a Pattern and a dictionary, print out all the strings that match the pattern.
where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).

e.g 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf"
2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"
*/
    private static void patternMatch (String pattern, Set<String> dictionary) {
        HashMap<Character, Character> match = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        for(String str : dictionary) {
            if (str.length() != pattern.length()) {
                continue;
            }
            match.clear();
            used.clear();
            boolean matches = true;
            for (int i = 0; i < str.length(); i++) {
                char chP = pattern.charAt(i);
                char chStr = str.charAt(i);
                Character mapped = match.get(chP);
                if (mapped == null) {
                    if(used.contains(chStr)) {
                        matches = false;
                        break;
                    }
                   match.put(chP, chStr);
                   used.add(chStr);
                   continue; 
                }
                if (mapped != chStr) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                System.out.println(str);
            }
        }
        
    }
}
