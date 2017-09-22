package Contest290;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] dots = new char[n][];
        for (int i = 0; i < n; i++) {
            dots[i] = scanner.next().toCharArray();
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if(!visited[i][j]) {
                   boolean result = dfs(visited, dots, i, j, -1, -1, n, m);
                   if(result) {
                       System.out.println("Yes");
                       return;
                   }
               }
            }
        }
        System.out.println("No");
        scanner.close();
    }

    private static boolean dfs(boolean[][] visited, char[][] dots, int x, int y, int previousX, int previousY, final int n, final int m ) {
        if(visited[x][y])
            return true;
        visited[x][y] = true;
        boolean result = false;
        if(x + 1 < n && x + 1 != previousX && dots[x][y] == dots[x + 1][y])
            result = dfs(visited, dots, x + 1, y, x, y, n, m);
        if(result) return true;
        if(x - 1 >= 0 && x - 1 != previousX && dots[x][y] == dots[x - 1][y])
            result = dfs(visited, dots, x - 1, y, x, y, n, m);
        if(result) return true;
        if(y + 1 < m && y + 1 != previousY && dots[x][y] == dots[x][y + 1])
            result = dfs(visited, dots, x, y + 1, x, y, n, m);
        if(result) return true;
        if(y - 1 >= 0 && y - 1 != previousY && dots[x][y] == dots[x][y - 1])
            result = dfs(visited, dots, x, y - 1, x, y, n, m);
        return result;
    }
}