package warmup.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class EqualSumm {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long summ = 0;
            long[] summs = new long[n];
            for (int j = 0; j < n; j++) {
                summ += scanner.nextInt();
                summs[j] = summ;
            }
            boolean found = false;
            if(summ - summs[0] == 0 || summs[n - 1] == 0) {
                System.out.println("YES");
                continue;
            }
            for (int j = 1; j < n-1; j++) {
                if(summ - summs[j] == summs[j-1]) {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "YES" : "NO");
        }
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
