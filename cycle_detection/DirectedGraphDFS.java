import java.util.*;
public class DirectedGraphDFS {
    public static boolean CycleDetection(List<List<Integer>> graph, boolean vis[], boolean pathvis[], int idx){
        vis[idx] = true;
        pathvis[idx] = true;
        for(int nei : graph.get(idx)){
            if(!vis[nei]){
                if(CycleDetection(graph, vis, pathvis, nei)){
                    return true;
                }
            }
        }

        pathvis[idx] = false;
        return false;

    }
    public static void checkAge(int age){
     Scanner sc = new Scanner(System.in);
     int vertex = sc.nextInt();
     int edge = sc.nextInt();
     List<List<Integer>> graph = new ArrayList<>();
     for(int i = 0; i<vertex; i++){
        graph.add(new ArrayList<>());
     }

     for(int i = 0; i<edge; i++){
        int src = sc.nextInt();
        int dest = sc.nextInt();
        graph.get(src).add(dest);
     }

    boolean vis[] = new boolean[vertex];
    boolean pathvis[] = new boolean[vertex];

    for(int i = 0; i<vertex; i++){
        if(!vis[i]){
            if(CycleDetection(graph, vis, pathvis, i)){
                System.out.println("Cycle is Present");
            }
        }
    }
    System.out.println("Cycle is not Present");
}

}
