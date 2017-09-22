package Contest294;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        Map<Character, Integer> sMap = createCharMap();
        Map<Character, Integer> tMap = createCharMap();
        int uraCount = 0;
        int opaCount = 0;
        fillMap(s, sMap);
        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            int counter = sMap.get(ct);
            if(counter > 0) {
                uraCount++;
                sMap.put(ct, --counter);
            } else {
                int unused = tMap.get(ct);
                tMap.put(ct, ++unused);
            }
        }
        for (Character character : sMap.keySet()) {
            int required = sMap.get(character);
            if(required == 0)
                continue;
            char alike = Character.isUpperCase(character) ? Character.toLowerCase(character) : Character.toUpperCase(character);
            int closeAm = tMap.get(alike);
            opaCount += Math.min(closeAm, required);
        }
        scanner.close();
        System.out.println(uraCount + " " + opaCount);
    }

    private static void fillMap(String s, Map<Character, Integer> sMap) {
        for (int i = 0; i < s.length(); i++) {            
            char cs = s.charAt(i);
            Integer counter = sMap.get(cs);
            if(counter == null)
                counter = 0;
            counter++;
            sMap.put(cs, counter);
        }
    }

    private static Map<Character, Integer> createCharMap() {
        Map<Character, Integer> map = new HashMap<>();
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (char c : alphabet) {
            map.put(c, 0);
        }
        return map;
    }
}
