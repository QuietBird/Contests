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
public class ServiceLane {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] width = new int[n];
        for (int i = 0; i < n; i++) {
            width[i] = scanner.nextInt();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int enter = scanner.nextInt();
            int exit = scanner.nextInt();
            int min = 4;
            for (int j = enter; j <= exit ; j++) {
                int wid = width[j];
                if(wid == 1) {
                    min = 1;
                    break;
                }
                min = Math.min(wid, min);
            }
            builder.append(min).append('\n');
        }
        System.out.println(builder.toString());
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
