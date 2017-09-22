package contests.w16_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task4 {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int milesTotal = scanner.nextInt();
        int hMin = scanner.nextInt();
        int hMax = scanner.nextInt();
        int startPoint = array[0] - hMax;

        int milesPassed = hMax;
        for (int i = 0; i < n - 1; i++) {
            if(milesPassed == milesTotal)
                break;
            int leftPoint = array[i];
            int rightPoint = array[i+1];
            int distance = Math.abs(rightPoint - leftPoint);
            if (distance < hMin) {
                startPoint = rightPoint;

                milesPassed = 0;
            } else if (distance > hMax) {
                startPoint = rightPoint - hMax;
                milesPassed = hMax;
            } else {
                milesPassed += distance;
            }
        }
        
        scanner.close();

        System.out.println(startPoint);
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
