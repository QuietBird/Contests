package contests.w13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class SwapAndSumm {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int quieries = scanner.nextInt();
        int[] array = new int[n+1];
        TreeMap<Integer, Integer> swapMapLeft = new TreeMap<>();
        TreeMap<Integer, Integer> swapMapRight = new TreeMap<>();
        for (int i = 1; i < n + 1; i++) {
            int nextInt = scanner.nextInt();
            array[i] = nextInt;
        }
        // 1 2 3 4 5 6 7 8 9 10
        // 1 3 2 5 4 6 7 8 9 10
        // 1 3 5 2 6 4 8 7 9 10
        // 1 3 5 2 4 6 7 8 9 10

        // 2, 5, 4,5 -> 2,3   3,8  4,7 -> 2,3 5,8 4,6
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < quieries; i++) {
            int type = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if(type == 1) {
                Integer put = swapMapLeft.put(left, right);
                if(put != null) {
                    int prevRight = put;
                    swapMapLeft.remove(left);
                    swapMapRight.remove(put);
                    if(right == prevRight)
                        continue;
                    int newLeft = Math.min(prevRight, right) + 1;
                    int newRight = Math.max(prevRight, right);
                    swapMapLeft.put(newLeft, newRight);
                    swapMapRight.put(newLeft, newRight);
                }
                Integer putR = swapMapRight.put(right, left);
                if(putR != null && put == null) {
                    int prevLeft = putR;
                    swapMapRight.remove(right);
                    swapMapLeft.remove(putR);
                    if(left == prevLeft)
                        continue;
                    int newLeft = Math.min(prevLeft, left);
                    int newRight = Math.max(prevLeft, left) - 1;
                    swapMapLeft.put(newLeft, newRight);
                    swapMapRight.put(newLeft, newRight);
                }
                if(put == null && putR == null) {
                    NavigableMap<Integer, Integer> leftIntervals = swapMapLeft.subMap(left, true, right, true);
                    NavigableMap<Integer, Integer> rightIntervals = swapMapLeft.subMap(left, true, right, true);
                    if(!leftIntervals.isEmpty() || !rightIntervals.isEmpty()) {
                        merge(swapMapLeft, array);
                        swapMapLeft.clear();
                        swapMapRight.clear();
                    }

                }
            }
            if(type == 2) {
                NavigableMap<Integer, Integer> leftIntervals = swapMapLeft.subMap(left, true, right, true);
                NavigableMap<Integer, Integer> rightIntervals = swapMapLeft.subMap(left, true, right, true);
                if(!leftIntervals.isEmpty() || !rightIntervals.isEmpty()) {
                    merge(swapMapLeft, array);
                    swapMapLeft.clear();
                    swapMapRight.clear();
                }
                buffer.append(countSumm(array, left, right)).append('\n');
            }
        }
        System.out.println(buffer.toString());
        System.err.println((now - System.currentTimeMillis()) / 1000);
        scanner.close();
    }

    private static void merge(NavigableMap<Integer, Integer> leftIntervals, int[] array) {
        int t;
        for (Integer left : leftIntervals.keySet()) {
            Integer right = leftIntervals.get(left);
            for (int i = left; i < right; i += 2) {
                t = array[i];
                array[i] = array[i+1];
                array[i+1] = t;
            }
        }
    }

    private static long countSumm(int[] array, int left, int right) {
        long summ = 0L;
        for (int i = left; i <= right; i++) {
            summ += array[i];
        }
        return summ;
    }

    private static void swapElements(int[] array, int left, int right) {
        int t;
        for (int i = left; i < right; i += 2) {
            t = array[i];
            array[i] = array[i+1];
            array[i+1] = t;
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

    /*
    6 4
1 2 3 4 5 6
1 2 5
2 2 3
2 3 4
2 4 5

5 7 9
     */
}
