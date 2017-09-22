package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int t = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            String newStr = "no answer";
            // dgea  zyx
            for (int j = str.length(); j > 0; j--) {
                char curChar = str.charAt(j);
                char nextChar = str.charAt(j - 1);
                if(curChar <= nextChar)
                    continue;
                StringBuilder builder = new StringBuilder(str);
                int rightPtr = str.length() - 1;
                int delta = curChar - nextChar;
                if(nextChar > str.charAt(rightPtr))


                newStr = builder.toString();
                break;
            }
            buffer.append(newStr).append('\n');
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
