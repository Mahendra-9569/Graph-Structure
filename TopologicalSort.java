import java.util.*;
public class TopologicalSort {

    public static void topologicalSortDFS(List<List<Integer>> graph, boolean visited[], Stack<Integer> stack, int node){
        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                topologicalSortDFS(graph, visited, stack, neighbour);
            }
        }
        stack.push(node);
    }
    public static void main(String args[]){
        // Use stack for store the order of the nodes
        // Use visited array to keep track of visited nodes

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
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[vertices];
        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                topologicalSortDFS(graph, visited, stack, i);
            }
        }
        System.out.println("Topological Sort: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
