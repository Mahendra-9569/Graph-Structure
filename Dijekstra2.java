import java.util.*;
public class Dijekstra2 {
    static class Info{
        int node;
        int edge;
        public Info(int node, int edge){
            this.node = node;
            this.edge = edge;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        List<List<Info>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the edge (u v w): ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Info(v, w));
            graph.get(v).add(new Info(u, w));
        }
        System.out.println("Graph: " + graph);
        Queue<Integer> q = new LinkedList<>();
        int ans[] = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int start = 0;
        q.add(start);
        ans[start] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(Info nbr : graph.get(node)){
                if(ans[node] + nbr.edge < ans[nbr.node]){
                    ans[nbr.node] = ans[node] + nbr.edge;
                    q.add(nbr.node);
                }
            }
        }

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + ans[i]);
        }
        scanner.close();
    }
}
