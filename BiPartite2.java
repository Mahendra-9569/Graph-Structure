import java.util.*;

public class BiPartite2 {
    public static boolean dfs(List<List<Integer>> graph, int node, int color, int[] colors) {
        colors[node] = color;

        for (int neighbor : graph.get(node)) {
            if (colors[neighbor] == -1) {
                if (!dfs(graph, neighbor, 1 - color, colors)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
                return false; 
            }
        }
        return true;
    }

    public static boolean isBipartite(List<List<Integer>> graph, int[] colors) {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, i, 0, colors)) return false;
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
