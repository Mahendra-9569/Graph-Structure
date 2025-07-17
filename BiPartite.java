import java.util.*;
public class BiPartite {
    static class Pair {
        int node;
        int color;

        public Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public static boolean isBipartite(List<List<Integer>> graph, int[] colors) {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!bfs(graph, i, colors)) return false;
            }
        }
        return true;
    }

    public static boolean bfs(List<List<Integer>> graph, int start, int[] colors) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        colors[start] = 0;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int color = current.color;

            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - color;
                    q.add(new Pair(neighbor, colors[neighbor]));
                } else if (colors[neighbor] == color) {
                    return false; 
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] colors = new int[vertices];
        Arrays.fill(colors, -1); 

        if (isBipartite(graph, colors)) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }
    }
}
