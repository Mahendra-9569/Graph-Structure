import java.util.*;
public class BFS {
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
       Queue<Integer> q = new LinkedList<>();
       q.add(0);


       while(!q.isEmpty()){
           int curr = q.remove();
           if(!vis[curr]) System.out.print(curr+" ");
           vis[curr] = true;

           for(int i: graph.get(curr)){
              q.add(i);
           }
       }

       
    }
}
