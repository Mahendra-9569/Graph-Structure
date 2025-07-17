import java.util.*;
public class DijekstraAlgo {
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
        int vetices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        List<List<Info>> graph = new ArrayList<>();
        for (int i = 0; i < vetices; i++) {
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
        int ans[] = new int[vetices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int start = 0;
        pq.add(new Pair(start, 0));
        ans[start] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            for(Info nbr : graph.get(node)){
                if(ans[node] + nbr.edge < ans[nbr.node]){
                    ans[nbr.node] = ans[node] + nbr.edge;
                    pq.add(new Pair(nbr.node, ans[nbr.node]));
                }
            }
        }


        System.out.println("Shortest distances from source: ");
        for(int i = 0; i < ans.length; i++){
            System.out.println("Distance from " + start + " to " + i + " is: " + ans[i]);
        }
    }
}
