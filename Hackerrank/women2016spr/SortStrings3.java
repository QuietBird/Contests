package women2016spr;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class SortStrings3 {
    private static class Frequency {
        private int[] digits = new int[10];
        
        public Frequency(String str) {
            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';
                digits[digit] = digits[digit] + 1;
            }             
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Frequency frequency = (Frequency) o;

            if (!Arrays.equals(digits, frequency.digits)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return digits != null ? Arrays.hashCode(digits) : 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Frequency, List<String>> map = new HashMap<>();
        Set<String> noCopies = new HashSet<>();
        int maxGroupSize = 1;
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if(noCopies.contains(str))
                continue;
            Frequency frq = new Frequency(str);
            List<String> strings = map.get(frq);
            if(strings == null) {
                strings = new ArrayList<>();
                map.put(frq, strings);
            }    
            strings.add(str);
            maxGroupSize = Math.max(maxGroupSize, strings.size());
            noCopies.add(str);
        }
        System.out.println(map.size());
        Queue<List<String>> queue = new PriorityQueue<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return Comparator.<String>naturalOrder().compare(o1.get(0), o2.get(0));
            }
        });
        for (List<String> strings : map.values()) {
            if(strings.size() < maxGroupSize)
                continue;
            strings.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Comparator.<String>naturalOrder().compare(o2, o1);
                }
            });
            queue.add(strings);
        }
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            List<String> poll = queue.poll();
            for (String s : poll) {
                result.append(s).append(" ");
            }
            result.append('\n');
        }
        System.out.println(result);
        scanner.close();
    }
}
