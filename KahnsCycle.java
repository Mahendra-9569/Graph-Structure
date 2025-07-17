
import java.util.*;
public class KahnsCycle {
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

        int indegree[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbour : graph.get(i)) {
                indegree[neighbour]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int index = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            index++;

            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (index != vertices) {
            System.out.println("Cycle detected in the graph");
        } else {
            System.out.println("Does'nt exit cycle : ");
        }
    }
}
