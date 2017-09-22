package Contest290;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }
        scanner.close();
        char[] defAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < defAlphabet.length; i++) {
            alphabet.put(defAlphabet[i], i);
        }
        LinkedList<Character> orderedChars = new LinkedList<>();
        for (int j = 0; j < n - 1; j++) {
            String first = names[j];
            String second = names[j + 1];
            int n1 = first.length();
            int n2 = second.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = first.charAt(i);
                char c2 = second.charAt(i);
                if (c1 != c2) {
                    int indexC1 = orderedChars.indexOf(c1);
                    int indexC2 = orderedChars.indexOf(c2);
                    if (indexC1 != -1 && indexC2 != -1) {
                        if (indexC1 > indexC2 && alphabet.get(c1) > alphabet.get(c2)) {
                            System.out.println("Impossible");
                            return;
                        }
                    } else {
                        if (indexC1 == -1 && indexC2 == -1) {
                            orderedChars.add(c1);
                            orderedChars.add(c2);
                        } else if (indexC1 == -1) {
                            orderedChars.add(Math.max(indexC2 - 1, 0), c1);
                        } else {
                            orderedChars.add(indexC1, c2);
                        }
                    }
                    int index = alphabet.get(c1);
                    int indexPopTo = alphabet.get(c2);
                    while(index > indexPopTo) {
                        char temp = defAlphabet[index - 1];
                        defAlphabet[index - 1] = c1;
                        defAlphabet[index] = temp;
                        index--;
                    }
                    for (int k = 0; k < defAlphabet.length; k++) {
                        alphabet.put(defAlphabet[k], k);
                    }
                    break;
                }
            }
        }
        char[] result = new char[defAlphabet.length];
        for (Map.Entry<Character, Integer> entry : alphabet.entrySet()) {
            result[entry.getValue()] = entry.getKey();
        }
        System.out.println(result);
    }

}
