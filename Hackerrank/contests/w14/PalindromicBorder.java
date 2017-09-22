package contests.w14;

import java.util.*;

public class PalindromicBorder {
    private static final long MODULO = 1000_000_007;
    
    // aaaa 10
    // aaacbaaa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;
        int dCounter = 0;
        int eCounter = 0;
        int fCounter = 0;
        int gCounter = 0;
        int hCounter = 0;
        long pCounter = 0;
        
        Map<String, List<Integer>> longPrefix2Pos = new HashMap<>();
        char[] str1 = str.toCharArray();
        char[] separated = new char[str1.length * 2 + 1];
        long[] alreadyCounted = new long[str1.length * 2 + 1];
        for (int j = 0; j < (separated.length - 1); j = j + 2) {
            separated[j] = '#';
            char c = str1[j / 2];
            separated[j + 1] = c;

            switch(c) {
                case 'a':
                    pCounter = addition(pCounter, aCounter, MODULO);
                    aCounter++;
                    break;
                case 'b':
                    pCounter = addition(pCounter, bCounter, MODULO);
                    bCounter++;
                    break;
                case 'c':
                    pCounter = addition(pCounter, cCounter, MODULO);
                    cCounter++;
                    break;
                case 'd':
                    pCounter = addition(pCounter, dCounter, MODULO);
                    dCounter++;
                    break;
                case 'e':
                    pCounter = addition(pCounter, eCounter, MODULO);
                    eCounter++;
                    break;
                case 'f':
                    pCounter = addition(pCounter, fCounter, MODULO);
                    fCounter++;
                    break;
                case 'g':
                    pCounter = addition(pCounter, gCounter, MODULO);
                    gCounter++;
                    break;
                case 'h':
                    pCounter = addition(pCounter, hCounter, MODULO);
                    hCounter++;
                    break;
            }
        }
        separated[separated.length - 1] = '#';
        int[] palindromeLengths = new int[separated.length];
        int length = 0, r = 0;
        int leftBound = 0;
        int rightBound = 0;
        for (int i = 1; i < separated.length; i++) {
            if (i > r) {
                palindromeLengths[i] = 0;
                leftBound = i - 1;
                rightBound = i + 1;
            } else {
                int index = length * 2 - i;
                if (palindromeLengths[index] < (r - i)) {
                    palindromeLengths[i] = palindromeLengths[index];
                    leftBound = -1;
                } else {
                    palindromeLengths[i] = r - i;
                    rightBound = r + 1;
                    leftBound = i * 2 - rightBound;
                }
            }
            while (leftBound >= 0 && rightBound < separated.length && separated[leftBound] == separated[rightBound]) {
                palindromeLengths[i]++;
                
                String palindrome = String.valueOf(separated, leftBound, rightBound + 1 - leftBound);
                List<Integer> positions = longPrefix2Pos.get(palindrome);
                if(positions == null) {
                    positions = new ArrayList<>();
                    positions.add(leftBound);
                    longPrefix2Pos.put(palindrome, positions);
                    continue;
                }
                long pOfSub = alreadyCounted[positions.get(0) + palindromeLengths[i]] - alreadyCounted[positions.get(0)];
                pCounter = addition(pCounter, positions.size()* pOfSub, MODULO);
                positions.add(leftBound);
                alreadyCounted[i] = pCounter;

                leftBound--;
                rightBound++;
            }
            if ((i + palindromeLengths[i]) > r) {
                length = i;
                r = i + palindromeLengths[i];
            }
        }
        System.out.println(pCounter);
    }

    private static long addition(long a, long b, long modulo) {
            if (modulo - a < b)
                return ((((a >> 1) + (b >> 1)) % (modulo >> 1)) << 1) + (a & 1) + (b & 1) - (modulo & 1);
            return (a + b) % modulo;
        }

        private static long multiplication (long a, long b, long modulo) {
            long remainder = 0;
            while (b > 0) {
                if ((b & 1) > 0) {
                    remainder = addition(a, remainder, modulo);
                }
                a = addition(a, a, modulo);
                b >>= 1;
            }
            return remainder;
        }

        private static long power(long a, long b, long modulo) {
            long remainder = 1;
            if (b <= 0) return -1;
            while (b > 0) {
                if ((b & 1) > 0) remainder = multiplication(a, remainder, modulo);
                a = multiplication(a, a, modulo);
                b >>= 1;
            }
            return remainder;
        }
}
