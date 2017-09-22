package Contest289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ClassB {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int colors = scanner.nextInt();
        int[] piles = new int[n];
        StringBuilder buffer = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int peebles = scanner.nextInt();
            piles[i] = peebles;
            min = Math.min(peebles, min);
            max = Math.max(peebles, max);
        }
        if (max - min > colors) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n; i++) {
            int pile = piles[i];
            for (int j = 0; j < min; j++) {
                buffer.append('1').append(' ');
            }
            for (int j = min, color = 1; j < pile; j++, color++) {
                buffer.append(color).append(' ');
            }
            buffer.append('\n');
        }
        System.out.println("YES");
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
