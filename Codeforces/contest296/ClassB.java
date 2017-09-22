package contest296;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClassB {
    public static void main(String[] args) {

        MyScanner scan = new MyScanner();
        int n = scan.nextInt();
        int[] errors = new int[n];
        for(int i = 0; i < n; i++) {
            errors[i] = scan.nextInt();
        }
        int firstError = 0;
        for (int i = 0; i < n - 1; i++) {
            firstError ^= errors[i];
            firstError ^= scan.nextInt();
        }
        firstError ^= errors[n - 1];
        firstError ^= 0;
        
        int secondError = 0;
        for (int i = 0; i < n - 2; i++) {
            secondError ^= errors[i];
            secondError ^= scan.nextInt();
        }
        secondError ^= errors[n - 2];
        secondError ^= errors[n - 1];
        secondError ^= firstError;
        secondError ^= 0;
        scan.close();
        System.out.println(firstError);
        System.out.println(secondError);
        
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
