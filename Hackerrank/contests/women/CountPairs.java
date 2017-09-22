package contests.women;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CountPairs {
    public static void main(String... args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int quiries = scanner.nextInt();
        List<Integer> arr = Arrays.asList(2, 3);
        InputStream in = System.in;
        int[] aaaIndex = new int[n + 1];
        int[] aaa = new int[100005];
        StringBuilder buffer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int newVal = scanner.nextInt();
            aaa[newVal] += 1;
            aaaIndex[i] = newVal;
        }
        for (int i = 0; i < quiries; i++) {
            int type = scanner.nextInt();
            if(type == 1) {
                int index = scanner.nextInt();
                int newVal = scanner.nextInt();
                int oldVal = aaaIndex[index];
                aaaIndex[index] = newVal;
                aaa[oldVal] -= 1;
                aaa[newVal] += 1;
            } 
            if(type == 3) {
                scanner.nextInt();
                scanner.nextInt();
            }

            if(type == 2) {
               int min = scanner.nextInt();
               int max = scanner.nextInt();

                
                int counter = 0;
                if (max - min + m < n) {
                    for (int j = Math.max(1, min - m); j < max; j++) {
                        int mult = aaa[j];
                        if (mult == 0)
                            continue;
                        int pairNumber = Math.min(m + j, max) - Math.max(min, j + 1) + 1;
                        counter += mult * pairNumber;

                    }
                } else {
                    for (int j = 1; j <= n; j++) {
                        int val = aaaIndex[j];
                        if (val >= max || val + m < min)
                            continue;
                        counter += Math.min(m + val, max) - Math.max(min, val + 1) + 1;

                    }
                }
                buffer.append(counter).append('\n');
            }
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
    
    
    
    private static class MyScanner {
            private BufferedReader br;
            private StringTokenizer st;

            public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException ignored) {
                    }
                }
                
                return st.nextToken();
            }

            public int nextInt() {
                return Integer.parseInt(next());
            }

            public long nextLong() {
                return Long.parseLong(next());
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }

            public String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException ignored) {
                }
                return str;
            }

            public void close() {
                try {
                    br.close();
                } catch (IOException ignored) {
                }
            }

        }

    class Player
    {
        String name;
        int score;
    }

}
