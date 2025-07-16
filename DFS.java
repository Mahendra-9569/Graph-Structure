import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

    public static void DfsTraversal(ArrayList<ArrayList<Integer>> graph, boolean vis[], int node){
        System.out.print(node+" ");
        vis[node] = true;
        for(int curr : graph.get(node)){
            if(!vis[curr]){
                DfsTraversal(graph, vis, curr);
            }
        }
    }
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int vertex = sc.nextInt();
       int edge = sc.nextInt();
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

       for(int i = 0; i<vertex; i++){
           graph.add(new ArrayList<>());
       }

       for(int i = 0; i<edge; i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph.get(u).add(v);

       }
       boolean vis[] = new boolean[vertex];
       DfsTraversal(graph, vis, 0);

    }
}
