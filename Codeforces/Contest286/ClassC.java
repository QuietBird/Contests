package Contest286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClassC {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> app2Position = new HashMap<>();
        Map<Integer, Integer> position2app = new HashMap<>();
        List<Integer> initialApp = new ArrayList();
        for (int i = 1; i <= n; i++) {
            int app = scanner.nextInt();
            app2Position.put(app, i);
            position2app.put(i, app);
            initialApp.add(app);
        }
        int t = 0;
        for (int i = 0; i < m; i++) {
            int app = initialApp.get(scanner.nextInt() - 1);
            int position = app2Position.get(app);
            t += position / k + 1;
            if(position > 1) {
                int switchApp = position2app.get(position - 1);
                app2Position.put(app, position - 1);
                app2Position.put(switchApp, position);
                position2app.put(position - 1, app);
                position2app.put(position, switchApp);
            }
        }
        System.out.println(t);
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
