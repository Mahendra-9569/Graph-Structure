import java.util.*;
public class CycleBFS {
    static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

     // using DFS (Stack)

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
    //  public static boolean isCycle(List<List<Integer>> graph, int start) {
    //     boolean visited[] = new boolean[graph.size()];
    //     Queue<Pair> q =  new LinkedList<>();
    //     q.add(new Pair(start, -1));

    //     while(!q.isEmpty()){
    //         Pair  p = q.remove();
    
    //         int node  = p.node;
    //         int parent = p.parent;
    //         visited[node] = true;
    //         for(int neighbour : graph.get(node)){
    //             if(!visited[neighbour]){
    //                 q.add(new Pair(neighbour, node));
    //             }else if(neighbour != parent){
    //                 return true;
    //             }
    //         }

    //     }

    //     return false;
    // }


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vetices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vetices; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter the edges (u v): ");

        for (int i = 0; i < edges; i++) {

            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // cycle detection

        boolean visited[] = new boolean[graph.size()];
        if(isCycleDFS(graph, visited, new Pair(0, -1))){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No cycle detected");
        }
    }

   
}
