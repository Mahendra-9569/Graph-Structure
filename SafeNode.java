
import java.util.*;
public class SafeNode {
    public static boolean isSafeDFS(List<List<Integer>> graph, boolean visited[], boolean pathvis[], int node, ArrayList<Integer> safeNodes){
        visited[node] = true;
        pathvis[node] = true;
    
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                if(isSafeDFS(graph, visited, pathvis, neighbour, safeNodes)){
                    return true;
                }
            }else if(pathvis[neighbour]){
                    return true; 
            }
        }
        pathvis[node] = false;
        safeNodes.add(node);
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
        }
        
        boolean visited[] = new boolean[vertices];
        boolean pathvis[] = new boolean[vertices];
        ArrayList<Integer> safeNodes = new ArrayList<>();
        
        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                if(isSafeDFS(graph, visited, pathvis, i, safeNodes)){
                    System.out.println("The graph contains a cycle for" + " " + i);
                }
                else{
                    System.out.println("The graph does not contain a cycle for" + " " + i);    
                }
            }
        }

        Collections.sort(safeNodes);
        System.out.println("Safe nodes in the graph: " + safeNodes);
        
    }
}
