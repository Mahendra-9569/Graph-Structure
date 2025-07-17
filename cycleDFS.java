import java.util.*;
public class cycleDFS {
    static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean isCycleDFS(List<List<Integer>> graph, boolean visited[], Pair p){
        int node = p.node;
        int parent = p.parent;
        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                return isCycleDFS(graph, visited, new Pair(neighbour, node));
            }
            else if(neighbour != parent){
                return true;
            }
        }
        return false;
     }
     
    public static void main(String args[]){
       
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
            graph.get(v).add(u);
        }

        boolean vis[] = new boolean[vertices];

        if(isCycleDFS(graph, vis, new Pair(0, -1))){
            System.out.print("cycle is detected");
        }
        else{
            System.out.print("cycle is not detected");
        }

    }
}


