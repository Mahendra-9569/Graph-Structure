import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

   public class CycleBFS {
     static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean isCycle(List<List<Integer>> graph, int start) {
        boolean visited[] = new boolean[graph.size()];
        Queue<Pair> q =  new LinkedList<>();
        q.add(new Pair(start, -1));

        while(!q.isEmpty()){
            Pair  p = q.remove();
    
            int node  = p.node;
            int parent = p.parent;
            visited[node] = true;
            for(int neighbour : graph.get(node)){
                if(!visited[neighbour]){
                    q.add(new Pair(neighbour, node));
                }else if(neighbour != parent){
                    return true;
                }
            }

        }

        return false;
    }

    public static void  main(String args[]){
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

        if(isCycle(graph, 0)){
            System.out.print("cycle is detected");
        }
        else{
            System.out.print("cycle is not detected");
        }




        



    }
}
