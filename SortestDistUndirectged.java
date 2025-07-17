import java.util.*;
public class SortestDistUndirectged {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v): ");

        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int dist = scanner.nextInt();

            graph.get(u).add(new Pair(v, dist));
            graph.get(v).add(new Pair(u, dist));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int ans[] = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int dist = node.dist;
            int vertex = node.node;

            for(Pair neighbour : graph.get(vertex)){
                if(ans[vertex] + neighbour.dist < ans[neighbour.node]){
                    ans[neighbour.node] = ans[vertex] + neighbour.dist;
                    q.add(new Pair(neighbour.node, ans[neighbour.node]));
                }
            }
        }
        
        System.out.println("Shortest distances from vertex 0:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + ans[i]);
        }
        scanner.close();

    }
}
