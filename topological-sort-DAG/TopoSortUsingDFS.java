
import java.util.*;

public class TopoSortUsingDFS {
    public static void DFS(int node, List<List<Integer>> graph, boolean visited[], Stack<Integer> st){
        visited[node] = true;
        for(int i: graph.get(node)){
            if(!visited[i]){
                DFS(i,graph,visited,st);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }  
        
        for(int i = 0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                DFS(i,graph,visited,st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }   
 
    }

}
