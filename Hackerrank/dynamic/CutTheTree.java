package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class CutTheTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] weights = new int[n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int rootNode = scanner.nextInt();
            int leaf = scanner.nextInt();
            List<Integer> leafs = tree.get(rootNode);
            if(leafs == null) {
                leafs = new ArrayList<>();
                tree.add(rootNode, leafs);
            }
            leafs.add(leaf);
        }
        scanner.close();
        int[] dfs;
    }

    private long dfs(List<List<Integer>> tree, boolean[] used, long[] summ ) {
        return 0;
    }
}
