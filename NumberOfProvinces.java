import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfProvinces {
     public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean vis[], int node){
        vis[node] = true;
        for(int curr : graph.get(node)){
            if(!vis[curr]){
                dfs(graph, vis, curr);
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
       int ans = 0;
       for(int i = 0; i<vertex; i++){
        if(!vis[i]){
            dfs(graph, vis, i);
            ans++;
        }
       }

    }
}
