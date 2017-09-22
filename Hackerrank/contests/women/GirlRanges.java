package contests.women;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class GirlRanges {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int girls = scanner.nextInt();
        int rings = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        int[] array = new int[girls + 1];
        for (int i = 0; i < rings; i++) {
            int rangeStart = scanner.nextInt();
            int rangeEnd = scanner.nextInt();
            array[rangeStart] += 1;
            array[rangeEnd] -= 1;
        }
        int counter = 0;
        int strongPairsCounter = 0;
        for (int i = 1; i <= girls ; i++) {
            if(array[i] == 0)
                continue;
            if(counter > 0) {
                if(array[i] == 1) {
                    buffer.append(i - 1).append(' ').append(i).append('\n');
                    strongPairsCounter++;
                } else {
                    if(counter - 1 > 0) {
                        buffer.append(i).append(' ').append(i + 1).append('\n');
                        strongPairsCounter++;
                    }
                }
                counter += array[i];
                
            } else {
                counter += array[i];
            }
        }
        
        System.out.println(strongPairsCounter + "\n" + buffer.toString());
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
}
