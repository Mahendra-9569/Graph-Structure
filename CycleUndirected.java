import java.util.*;
public class CycleUndirected {

    public static boolean isCycleDFS(List<List<Integer>> graph, boolean visited[], boolean pathvis[], int node){
        visited[node] = true;
        pathvis[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                if(isCycleDFS(graph, visited, pathvis, neighbour)){
                    return true;
                }
            }else if(pathvis[neighbour]){
                return true;
            }
        }
        pathvis[node] = false;
        return false;
    }
 
    public static void main(String args[]){
        // Directed graph
        // using DFS (Stack)
        
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
        
        }
        
        boolean visited[] = new boolean[vertices];
        boolean pathvis[] = new boolean[vertices];
        
        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                if(isCycleDFS(graph, visited, pathvis, i)){
                    System.out.println("The graph contains a cycle for" + i);
                }
                else{
                    System.out.println("The graph does not contain a cycle for" + i);    
                }
            }
        }
        


      
    }
}
