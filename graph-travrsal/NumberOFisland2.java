
import java.util.*;
public class NumberOFisland2 {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int index = 0;
    public static void BFS(int row, int col, int grid[][], boolean visited[][], int x[], int y[], int ans[], int val){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        visited[row][col] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.row;
            int j = curr.col;
            ans[index++] = val;
            for(int k = 0; k<4; k++){
                int nrow = i + x[k];
                int ncol = j + y[k];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
      
    }
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int grid[][] = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            int positions[][] = {{0,0},{0,1},{1,2},{2,1}};
            for(int i = 0; i<positions.length; i++){
                    grid[positions[i][0]][positions[i][1]] = 1; 
            }


            int ans[] = new int[positions.length];
            int x[] = {0,0,1,-1};
            int y[] = {1,-1,0,0};
            int val = 1;
            boolean visited[][] = new boolean[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(!visited[i][j] && grid[i][j] == 1){
                        BFS(i,j,grid,visited,x,y,ans,val);
                        val++;
                    }
                }
            }

            System.out.println(Arrays.toString(ans));
            sc.close();
}

}
