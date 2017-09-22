package contests.w14;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberList {
    public static void main(String[] args) {
        MyScanner scan = new MyScanner();
        int tests = scan.nextInt();
        StringBuilder strBuff = new StringBuilder();
        for(int i = 0; i < tests; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            long counter = 0;
            long seqLessK = 0;
            for (int j = 1; j <= n; j++) {
                if(scan.nextInt() > k) {
                    counter += j;
                    seqLessK = 0;
                } else {
                    seqLessK++;
                    counter += j - seqLessK;
                }
            }
            /*for (int j = 0; j < n; j++) {
                if(scan.nextInt() > k)
                    counter++;                
            }
            long setCounter = 0;
            if(counter != 0) {
                long cnk = n;
                long notKcnk = n - counter;
                for (int len = 1; len < n; len++) {
                    if(len > n - counter) {
                        setCounter += cnk;
                    } else {
                        setCounter += cnk - notKcnk;
                    }
                    cnk = (cnk * (n - len)) / (len + 1);
                    notKcnk = (notKcnk * (n-counter- len )) / (len + 1);
                }
            }*/
            strBuff.append(counter).append('\n');
        }
        scan.close();
        System.out.println(strBuff.toString());
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
