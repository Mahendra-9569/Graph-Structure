import java.util.*;
public class NearestOnes {
    static class Pair{
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String args[]){
        int graph[][] = {
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
        };

        
        int ans[][] = new int[graph.length][graph[0].length];
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[graph.length][graph[0].length];

        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(graph[i][j] == 1 && visited[i][j] == false){
                    q.add( new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int delrow[] = { -1, 1, 0, 0 };
        int delcol[] = { 0, 0, -1, 1 };

        while(!q.isEmpty()){
            Pair p = q.remove();
            int i = p.x;
            int j = p.y;
            int dist = p.dist;
            ans[i][j] = dist;
            for(int k  = 0; k<4; k++){
                int newi = i + delrow[k];
                int newj = j + delcol[k];
                if(newi >= 0 && newi < graph.length && newj >= 0 && newj < graph[0].length && visited[newi][newj] == false){
                    q.add(new Pair(newi, newj, dist + 1));
                    visited[newi][newj] = true;
                }
            }

        }

        for(int i = 0; i<ans.length; i++){
            for(int j = 0; j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}
