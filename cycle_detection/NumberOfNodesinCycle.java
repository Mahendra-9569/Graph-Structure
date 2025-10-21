import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfNodesinCycle {
    public static boolean CycleDetection(List<List<Integer>> graph, boolean vis[],
            boolean pathvis[], int idx, List<Integer> ans, int[] parent) {
        vis[idx] = true;
        pathvis[idx] = true;
        for (int nei : graph.get(idx)) {
            if (!vis[nei]) {
                parent[nei] = idx;
                if (CycleDetection(graph, vis, pathvis, nei, ans, parent)) {
                    return true;
                }
            } else if (pathvis[nei]) {
                int find = nei;
                int curr = idx;
                while (curr != find) {
                    ans.add(curr);
                    curr = parent[curr];
                }
                ans.add(find);
                return true;
            }
        }

        pathvis[idx] = false;
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.get(src).add(dest);
        }

        boolean vis[] = new boolean[vertex];
        boolean pathvis[] = new boolean[vertex];
        List<Integer> ans = new ArrayList<>();
        int parent[] = new int[vertex];
        parent[0] = -1;
        for (int i = 0; i < vertex; i++) {
            if (!vis[i]) {
                if (CycleDetection(graph, vis, pathvis, i, ans, parent)) {
                    System.out.println(ans);
                }
            }
        }

    }
}
