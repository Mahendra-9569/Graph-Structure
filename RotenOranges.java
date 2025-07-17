import java.util.*;
public class RotenOranges {
    static class Info{
        int i;
        int j;
        int tm;
        public Info(int i, int j, int tm){
            this.i = i;
            this.j = j;
            this.tm = tm;
        }


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];
        System.out.println("Enter the grid values (0 for empty, 1 for fresh orange, 2 for rotten orange):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(2,2,0));

        int x[] = {1,0,-1,0};
        int y[] = {0,1,0,-1};
        int ans = 0;
        while(!q.isEmpty()){
            Info curr = q.remove();
            int i = curr.i;
            int j = curr.j;
            ans = curr.tm;
            for(int k = 0; k<4; k++){
                int row = i + x[k];
                int col = j + y[k];
                if(row>0 && row<grid.length && col >0 && col<grid[0].length && grid[row][col] == 1){
                    grid[row][col] = 2;
                    q.add(new Info(row, col, curr.tm +1));
                }
            }
        }

        System.out.print(ans);


    } 
}
