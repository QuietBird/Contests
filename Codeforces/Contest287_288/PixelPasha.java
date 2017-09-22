package Contest287_288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class PixelPasha {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] field = new int[n+1][m+1];
        for (int t = 1; t <= k; t++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            field[i][j] = 1;
            if(isSquareFilled(field, i-1, j-1, n, m) || isSquareFilled(field, i, j-1, n, m) || isSquareFilled(field, i-1, j, n, m) || isSquareFilled(field, i, j, n, m)) {
                System.out.println(t);
                return;
            }
        }
        System.out.println('0');
        scanner.close();
    }

    private static boolean isSquareFilled(int[][] field, int i, int j, int n, int m) {
        if(i <= 0 || j <= 0 || i >= n || j >= m)
            return false;
        return field[i][j] == 1 && field[i+1][j] == 1 && field[i+1][j+1] == 1 && field[i][j+1] == 1;
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
