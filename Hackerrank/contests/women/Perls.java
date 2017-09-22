package contests.women;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Perls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>(/*new Comparator<Long>() {

            @Override
            public int compare(Long o1, Long o2) {
                return -Long.compare(o1, o2);
            }
        }*/n);
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextLong());
        }
        long summ = 0;
        while(queue.size() > 1) {
            Long a = queue.poll();
            Long b = queue.poll();
            summ = (a + summ) % 1000_000_007;
            summ = (b + summ) % 1000_000_007;
            queue.add(a + b);
        }
        System.out.println(summ);
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
