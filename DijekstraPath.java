import java.util.*;
public class DijekstraPath {
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other) {
            return this.dist - other.dist;
        }
    }

    static class Info{
        int node;
        int edge;
        public Info(int node, int edge){
            this.node = node;
            this.edge = edge;
        }
    }
    public static void main(String args[]){
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

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[vertices];
        int parent[] = new int[vertices];
        for(int i = 0; i < vertices; i++){
            parent[i] = i;
        }
        Arrays.fill(ans, Integer.MAX_VALUE);
        int start = 0;
        pq.add(new Pair(start, 0));
        ans[start] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int dist = p.dist;
            for(Info nbr : graph.get(node)){
                if(dist + nbr.edge < ans[nbr.node]){
                    ans[nbr.node] = dist + nbr.edge;
                    parent[nbr.node] = node;
                    pq.add(new Pair(nbr.node, ans[nbr.node]));
                }
            }
        }

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + ans[i]);
        }

        ArrayList<Integer> path = new ArrayList<>();
        int end = 4; 
        while(end != start){
            path.add(end);
            end = parent[end];
        }
        path.add(start);
        Collections.reverse(path);

        System.out.println("Shortest path from node " + start + " to node " + end + ":");
        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}
