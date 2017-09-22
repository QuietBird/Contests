package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class MaxGrowingSubseqLength {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        scanner.close();
        System.out.println(findMaxLengthDynamic(array));
    }

    private static int findMaxLengthDynamic(int[] array) {
        int n = array.length;
        int[] lengths = new int[n];
        Arrays.fill(lengths, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            int localMax = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i])
                    localMax = Math.max(localMax, lengths[j] + 1);
            }
            lengths[i] = localMax;
            max = Math.max(max, localMax);
        }
        return max;
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
