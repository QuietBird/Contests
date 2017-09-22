package contests.w14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreesAndWeight {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        Node[] tree = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new Node();
        }
        for (int i = 1; i <= n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree[x].children.add(tree[y]);
            tree[y].children.add(tree[x]);
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(tree[1]);
        tree[1].depth = 0;
        while(!queue.isEmpty()) {
            Node parent = queue.poll();
            for (Node child : parent.children) {
                child.depth = parent.depth + 1;
                child.root = parent;
                child.children.remove(parent);
                queue.add(child);
            }
        }

        int queries = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        boolean needUpdate = false;
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.depth > o2.depth ? 1 : o1.depth < o2.depth ? -1 : 0;
            }
        };
        LinkedList<Node> updateQueue = new LinkedList<>();
        for (int i = 0; i < queries; i++) {
            String command = scanner.next();
            if("add".equals(command)) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                if (value == 0)
                    continue;
                Node node = tree[index];
                node.delta += value;
                if(!updateQueue.contains(node) && node.delta != 0) {
                    updateQueue.add(node);
                    needUpdate = true;
                } else if (updateQueue.contains(node) && node.delta == 0) {
                    updateQueue.remove(node);
                    if(updateQueue.isEmpty())
                        needUpdate = false;
                }
                
            } else {
                if(needUpdate) {
                    update(updateQueue, nodeComparator);
                    needUpdate = false;
                }
                int index1 = scanner.nextInt();
                int index2 = scanner.nextInt();
                long value;
                if(index1 == index2) {
                    Node node = tree[index1];
                    value = node.value;
                } else {
                    Node node1 = tree[index1];
                    Node node2 = tree[index2];
                    long value1 = node1.value;
                    long value2 = node2.value;
                    value = Math.max(value1, value2);
                    if(node1.depth > node2.depth) {
                        int delta = node1.depth - node2.depth;
                        while (delta > 0) {
                            value = Math.max(value, node1.root.value);
                            node1 = node1.root;
                            delta--;
                        }
                    } else if (node2.depth > node1.depth) {
                        int delta = node2.depth - node1.depth;
                        while (delta > 0) {
                            value = Math.max(value, node2.root.value);
                            node2 = node2.root;
                            delta--;
                        }
                    }
                    while (node1 != node2) {
                        value = Math.max(value, node1.root.value);
                        value = Math.max(value, node2.root.value);
                        node1 = node1.root;
                        node2 = node2.root;
                    }
                }
                buffer.append(value).append('\n');
            }

        }
        System.out.println(buffer.toString());
        scanner.close();
    }

    private static void update(LinkedList<Node> updateQueue, Comparator<Node> nodeComparator) {
        Collections.sort(updateQueue, nodeComparator);
        LinkedList<Node> queue = new LinkedList<>();
        while(!updateQueue.isEmpty()) {
            queue.add(updateQueue.poll());
            while (!queue.isEmpty()) {
                Node parent = queue.poll();
                if(parent.delta == 0)
                    continue;
                parent.value += parent.delta;
                for (Node child : parent.children) {
                    if(updateQueue.contains(child)) {
                        child.delta += parent.delta;
                        continue;
                    }
                    child.delta += parent.delta;
                    queue.add(child);
                }
                parent.delta = 0;
            }
        }
    }

    private static class Node {
        Node root;
        final List<Node> children = new ArrayList<>(2);
        int depth;
        long value;
        long delta;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", depth=" + depth +
                    ", delta=" + delta +
                    '}';
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
}

