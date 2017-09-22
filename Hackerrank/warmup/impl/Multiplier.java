package warmup.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Multiplier {
    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] aaa = new int[n + 1];
        int[] bbb = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            aaa[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            bbb[i] = scanner.nextInt();
        }
        long q = 1;
        for (int i = 1; i <= m; i++) {
            int b = bbb[i];
            long c = scanner.nextInt();
            if (c == 1)
                continue;
            if (b == 1) {
                q = (q * c) % 1000_000_007L;
                continue;
            }
            for (int j = b; j <= n; j += b) {
                aaa[j] = (int) ((aaa[j] * c) % 1000_000_007L);
            }
        }
        scanner.close();
        StringBuilder builder = new StringBuilder();
        if (q != 1) {
            for (int i = 1; i <= n; i++)
                builder.append((int) ((aaa[i] * q) % 1000_000_007L)).append(' ');
        } else {
            for (int i = 1; i <= n; i++)
                builder.append(aaa[i]).append(' ');
        }
        System.out.println(builder);
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
