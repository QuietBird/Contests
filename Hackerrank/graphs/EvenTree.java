package graphs;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class EvenTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] tree = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int j = scanner.nextInt(); // node
            int k = scanner.nextInt(); // leaf

            tree[j][k] = 1;
            tree[k][j] = -1;
        }
        int[] amountOfNodes = new int[n + 1];
        int leaf = -1;
        outer: for (int i = 1; i <= n; i++) {
            int[] row = tree[i];
            boolean hasEdge = false;
            for (int j : row) {
                if (j == 0)
                    continue;
                if (hasEdge)
                    continue outer;
                hasEdge = true;
            }
            leaf = i;
            break;
        }
        int[] result = new int[n + 1];
        dfs(tree, leaf, new boolean[n+1], result);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == leaf)
                continue;
            if (result[i] % 2 == 0)
                count++;
        }
        System.out.println(count);
        scanner.close();
    }

    private static void dfs(int[][] tree, int node, boolean[] used, int[] result) {
        int[] row = tree[node];
        used[node] = true;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0)
                continue;
            if (!used[i])
                dfs(tree, i, used, result);
        }
        int count = 1;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0)
                continue;
            count += result[i];
        }
        result[node] = count;
    }

    private class Node<T> {
        private List<Node<T>> children = new ArrayList<>();
        private Node<T> parent;
        private T value;

        public Node(Node<T> parent, T value) {
            this.value = value;
            this.parent = parent;
        }

        public void addChild(T val) {
            children.add(new Node<T>(this, val));
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public Node<T> getParent() {
            return parent;
        }

        public T getValue() {
            return value;
        }
    }
}
