
import java.util.*;
public class KahnsSafeNodes {
    // first reverse the graph
    // then find the indegree of each node
    // then find the nodes with indegree 0
    // and just do kahns algo abd find topo sort that is the safe nodes
    // then return the nodes in sorted order
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

        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
        }
        
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int indegree[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices; i++) {
            for (int neighbour : graph.get(i)) {
                reverseGraph.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbour : reverseGraph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        Collections.sort(safeNodes);
        System.out.println("Safe nodes in the graph: " + safeNodes);
    }
}
