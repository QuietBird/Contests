package contests.w13;

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
public class MinBullets {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int levelAmount = scanner.nextInt();
            int enemyAmount = scanner.nextInt();
            int[][] enemiesOnLevels = new int[levelAmount][enemyAmount];
            for (int j = 0; j < levelAmount; j++) {
                for (int k = 0; k < enemyAmount; k++) {
                    enemiesOnLevels[j][k] = scanner.nextInt();
                }
            }
            int[][] bulletsOnLevels = new int[levelAmount][enemyAmount];
            for (int j = 0; j < levelAmount; j++) {
                for (int k = 0; k < enemyAmount; k++) {
                    bulletsOnLevels[j][k] = scanner.nextInt();
                }
            }
            int min = Integer.MAX_VALUE;
            int[][] requiredBullets = new int[levelAmount][enemyAmount];
            System.arraycopy(enemiesOnLevels[0], 0, requiredBullets[0], 0, enemyAmount);
            for (int j = 1; j < levelAmount; j++) {
                for (int k = 0; k < enemyAmount; k++) {
                    int locMin = Integer.MAX_VALUE;
                    int enemyPower = enemiesOnLevels[j][k];
                    for (int q = 0; q < enemyAmount; q++) {
                        int prevBullets = requiredBullets[j - 1][q];
                        locMin = Math.min(locMin, Math.max(prevBullets + enemyPower - bulletsOnLevels[j-1][q], prevBullets));
                    }
                    requiredBullets[j][k] = locMin;
                }
            }
            for (int j = 0; j < enemyAmount; j++) {
                min = Math.min(min, requiredBullets[levelAmount-1][j]);
            }
            buffer.append(min).append('\n');
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

    /*
    2
3 3

3 2 1
1 2 3
3 2 1

1 2 3
3 2 1
1 2 3

3 3
3 2 5
8 9 1
4 7 6
1 1 1
1 1 1
1 1 1

1
3 4
1 1 1 1
4 6 2 3
7 10 11 17

5 2 4 1
7 34 2 5
1 2 2 2

     */
}
