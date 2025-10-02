public class UniquePathIII{
    static int ans;
    public static void uniquePath(int grid[][], int n, int m, int row, int col, int total){
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == -1){
            return;
        }
        if(grid[row][col] == 2){
            if(total == 0){
                ans++;
            }
            return;
        }
        int temp = grid[row][col];
        grid[row][col] = -1;
        uniquePath(grid,n,m,row+1,col,total-1);
        uniquePath(grid,n,m,row-1,col,total-1);
        uniquePath(grid,n,m,row,col+1,total-1);
        uniquePath(grid,n,m,row,col-1,total-1);
        
        grid[row][col] = temp;
    
    }
        
    public static void main(String[] args) {
        int grid[][] = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        
        int n = grid.length;
        int m = grid[0].length;
        ans = 0;
        int zero  = 0;
        int row = 0;
        int col = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    zero++;
                }
                else if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }
            }
        }

     
        uniquePath(grid, n, m, row, col, zero + 1);
        System.out.println(ans);
    }

}