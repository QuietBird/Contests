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
public class CabbHills {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int tests = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int hills = scanner.nextInt();
            int ropes = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < hills; j++) {
                graph.add(new ArrayList<Integer>(1));
            }
            for (int j = 0; j < ropes; j++) {
                ArrayList<Integer> paths = graph.get(scanner.nextInt() - 1);
                paths.add(scanner.nextInt() - 1);
            }
            boolean result = isSafe(graph, hills, ropes);
            buffer.append(result ? "Go on get the Magical Lamp" : "Danger!! Lucifer will trap you").append('\n');
        }
        System.out.println(buffer.toString());
        scanner.close();
    }
    
    private static void remove(ArrayList<ArrayList<Integer>> graph, int from, int to) {
        ArrayList<Integer> integers = graph.get(from);
        for (int i = 0; i < integers.size(); i++) {
            if (to == integers.get(i)) {
                integers.remove(i);
                return;
            }
        }
    }

    private static boolean isSafe(ArrayList<ArrayList<Integer>> graph, int hills, int ropes) {
        ArrayList<Integer> toVisit = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        Queue<Integer> toLookup = new ArrayDeque<>();
        Set<Integer> everything = new HashSet<>();
        toLookup.add(0);
        everything.add(0);
        while(!toLookup.isEmpty()) {
            Integer value = toLookup.poll();
            while(true) {
                toVisit.clear();
                toVisit.add(value);
                used.clear();
                used.add(value);
                List<Integer> dfs = dfs(graph, toVisit, used);
                if (dfs == null) {
                    break;
                }
                int prev = value;
                for (int i = 1; i < dfs.size(); i++) {
                    int next = dfs.get(i);
                    if (!everything.contains(next)) {
                        everything.add(next);
                        toLookup.add(next);
                    }
                    remove(graph, prev, next);
                    prev = next;
                }
                remove(graph, prev, value);
            }
        }
        if (!everything.contains(graph.size() - 1))
            return false;
        for (ArrayList<Integer> integers : graph) {
            if (!integers.isEmpty())
                return false;
        }
        return true;
    }

    private static List<Integer> dfs(ArrayList<ArrayList<Integer>> graph, List<Integer> path, Set<Integer> used) {
        int current = path.get(path.size() - 1);
        int first = path.get(0);
        ArrayList<Integer> nexts = graph.get(current);
        for (Integer next : nexts) {
            if (used.contains(next)) {
                if (next == first)
                    return path;
                continue;
            }
            used.add(next);
            path.add(next);
            List<Integer> result = dfs(graph, path, used);
            if (result != null)
                return result;
            path.remove(path.size() - 1);
            used.remove(next);
        }
        return null;
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
