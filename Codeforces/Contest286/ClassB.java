package Contest286;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edgesNum = scanner.nextInt();
        List<Integer>[][] graph = new List[nodes + 1][nodes + 1];
        Set<Integer> colors = new HashSet<Integer>();
        for (int i = 0; i < edgesNum; i++) {
            int node = scanner.nextInt();
            int child = scanner.nextInt();
            int color = scanner.nextInt();
            List<Integer> coloredEdges = graph[node][child];
            if(coloredEdges == null) {
                coloredEdges = new ArrayList<Integer>();
                graph[node][child] = coloredEdges;
            }
            coloredEdges.add(color);
            List<Integer> coloredEdges2 = graph[child][node];
            if(coloredEdges2 == null) {
                coloredEdges2 = new ArrayList<Integer>();
                graph[child][node] = coloredEdges2;
            }
            coloredEdges2.add(color);
            colors.add(color);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int counter = 0;
            for (Integer color : colors) {
                boolean[] visited = new boolean[nodes + 1];
                LinkedList<Integer> toVisit = new LinkedList<Integer>();
                toVisit.add(u);
                counter += bfs(graph, color, visited, toVisit, 0, v);
            }
            System.out.println(counter);
        }
        scanner.close();
    }

    private static int bfs(List<Integer>[][] graph, Integer color, boolean[] visited, LinkedList<Integer> toVisit, int counter, int target) {
        if(toVisit.isEmpty())
            return counter;
        Integer node = toVisit.poll();
        visited[node] = true;
        for (int i = 1; i < graph.length; i++) {
            List<Integer> coloredEdges = graph[node][i];
            if(coloredEdges == null)
                continue;
            for (int colorE : coloredEdges) {
                if(colorE != color)
                    continue;
                if(i == target) {
                    counter++;
                    break;
                }
                if(!visited[i])
                    toVisit.add(i);
            }
        }
        return bfs(graph, color, visited, toVisit, counter, target);
    }

    private static class ColoredEdge {
        public final int nextNode;
        public final int color;

        private ColoredEdge(int nextNode, int color) {
            this.nextNode = nextNode;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ColoredEdge that = (ColoredEdge) o;

            if (color != that.color) return false;
            if (nextNode != that.nextNode) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = nextNode;
            result = 31 * result + color;
            return result;
        }
    }
}
