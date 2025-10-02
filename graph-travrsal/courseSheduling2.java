import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class courseSheduling2 {
     public static void findOrder(int n, int[][] p) {
        List<List<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[n];
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<p.length; i++){
            graph.get(p[i][1]).add(p[i][0]);
            indegree[p[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int cnt = 0; 
        int ans[] = new int[n];
        while(!q.isEmpty()){
            int node = q.remove();
            ans[cnt++] = node;
            for(int i: graph.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }     
        }

        if(cnt != n){
          System.out.println(-1);
        }
          System.out.println(ans);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int n = sc.nextInt();
        int p[][] = new int[n][2];
        for (int i = 0; i<n; i++ ) {
          for(int j = 0; j<2; j++){
              p[i][j] = sc.nextInt();   
          }
        }
        findOrder(numCourses-1, p);

        
    }
}
