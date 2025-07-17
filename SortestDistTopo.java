import java.util.*;
public class SortestDistTopo {
    // first find topo sort and store it in a stack or queue what ever 
    // then find the distance of each node from the source node
    //use a ans array and initilize it with infinity
    // then pop the elements from the stack and find the distance of each nodes
    // if ans[node] + weight < ans[neighbour] then update the ans[neighbour]
    // then return the ans array


    // we can find all the distances for all DAG using kahns and topo sort 
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void topoLogicalSort(List<List<Pair>> graph, int node, boolean[] visited, Stack<Integer> stack) {
         visited[node] = true;
           for(Pair neighbou : graph.get(node)){
               if(!visited[neighbou.node]){
                   topoLogicalSort(graph, neighbou.node, visited, stack);
               }
           }
           stack.push(node);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int dist = scanner.nextInt();
            graph.get(u).add(new Pair(vertices, dist)   );
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        topoLogicalSort(graph, 6, visited, stack);

        int ans[] = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[6] = 0;

        while(!stack.isEmpty()){
            int node = stack.pop();
            for(Pair neighbour : graph.get(node)){
               int dist = neighbour.dist;
               if(ans[node] + dist < ans[neighbour.node]){
                   ans[neighbour.node] = ans[node] + dist;
               }
            }
        }
        

        System.out.println("Shortest distance from source node to each node: ");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + (ans[i] == Integer.MAX_VALUE ? "Infinity" : ans[i]));
        } 
        scanner.close();
    }
}
