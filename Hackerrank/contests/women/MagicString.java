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
public class MagicString {
    private static final int LENGTH = 5000000;
    private static int[] BUFFER = new int[LENGTH];

    private static void fillBuffer() {
        int N = LENGTH;
        int[] array = new int[N + 1];
        array[0] = 1;
        int counterOne = 1;
        array[1] = 2;
        array[2] = 2;
        int pt = 2;
        BUFFER[0] = 1; 
        BUFFER[1] = 1; 
        BUFFER[2] = 1; 

        for (int j = 3; j < N; j++, pt++) {
            if(array[pt] == 1) {
                array[j] = (array[j - 1] == 1 ? 2 : 1);
                if(array[j] == 1) {
                    counterOne++;
                }
                BUFFER[j] = counterOne;
            } else {
                int newValue = array[j - 1] == 1 ? 2 : 1;
                array[j] = newValue;
                if(newValue == 1) {
                    counterOne++;
                }
                BUFFER[j] = counterOne;
                array[++j] = newValue;
                if(j < N) {
                    if(newValue == 1) {
                        counterOne++;
                    }
                    BUFFER[j] = counterOne;
                }
            }
        }
        System.out.println("ddd");

    }

    public static void main(String[] args) {
        fillBuffer();
        MyScanner scanner = new MyScanner();
        int tests = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            boolean one = scanner.nextInt() == 1;
            int N = scanner.nextInt();
            int val = BUFFER[N - 1];
            buffer.append(one ? val : N - val).append('\n');
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
}
