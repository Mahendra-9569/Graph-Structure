import java.util.*;
public class TopoSortUsingBFS {
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
        int indegre[] = new int[n];
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n;  i++){
            for(int j: graph.get(i)){
                indegre[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegre[i] == 0){
                q.add(i);
            }
        }

        int ans[] = new int[n];
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[cnt++] = curr;
            vis[curr] = true;
            for(int nei: graph.get(curr)){
              if(!vis[nei]){
                indegre[nei]--;
                if(indegre[nei] == 0 ){
                    q.add(nei);
                }
              }
            }
        }

        if(cnt == n){
            System.out.println("I believe it is a DAG ");
            System.out.println(ans);
        }
        else{
            System.out.println("it is not a DAG");
        }


    }
}
