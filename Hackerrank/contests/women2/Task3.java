package contests.women2;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task3 {
    
    private static final HashSet<Integer> primes = new HashSet<>();
    static {
        for (int i = 2; i < 8192; i++) {
            boolean isPrime = true;
            for (Integer prime : primes) {
                if(i % prime == 0) {
                    isPrime = false;
                    break;
                }                    
            }
            if(isPrime) {
                primes.add(i);
            }
        }
        
    }
    
    private static boolean isPrime(int i) {        
      return primes.contains(i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            TreeMap<Integer, Integer> numbers = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                int number = scanner.nextInt();
                Integer count = numbers.get(number);
                if(count == null) {
                    count = 0;
                }
                numbers.put(number, count + 1);
            }
            HashMap<Integer, Integer> xors = new HashMap<>();
            xors.put(0, 1);
            for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
                int number = entry.getKey();
                int repetitions = entry.getValue();
                HashMap<Integer, Integer> next = new HashMap<>();
                for (Map.Entry<Integer, Integer> xorsEntry : xors.entrySet()) {
                   int previousXor = xorsEntry.getKey();
                   int previousCount = xorsEntry.getValue();
                    int newXor = previousXor ^ number;
                    long mod = previousCount;
                    next.put(newXor, (int) ((mod*((repetitions + 1) / 2)) %  1000_000_007));
                    next.put(previousXor, (int) ((mod*(repetitions / 2 + 1))% 1000_000_007));
                }
                System.err.println(xors + " ^ " + entry + " = " +next);
                xors = next;
            }
            
            long multisetCounter = 0;
            for (Map.Entry<Integer, Integer> entry : xors.entrySet()) {
                if (isPrime(entry.getKey())) {
                    multisetCounter = (multisetCounter + entry.getValue()) % 1000_000_007;
                }
            }
            System.out.println(multisetCounter % 1000_000_007);
        }
        scanner.close();
    }
    
}
