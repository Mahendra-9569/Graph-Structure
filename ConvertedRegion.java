public class ConvertedRegion {

    public static void DFS(int graph[][], boolean visited[][], int row, int col, int delrow[], int delcol[]){
        visited[row][col] = true;
        for(int i = 0; i<4; i++){
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];
            if(newrow >= 0 && newrow < graph.length && newcol >= 0 && newcol < graph[0].length && visited[newrow][newcol] == false && graph[newrow][newcol] == 0){
                    DFS(graph, visited, newrow, newcol, delrow, delcol);   
            }
        }
    }
    public static void main(String args[]){
        int graph[][] ={
            {1, 1, 0, 0},
            {1, 0, 1, 0},
            {1, 0, 0, 1},
            {1, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 0, 0, 1},

        };

        int delrow[] = { -1, 1, 0, 0 };
        int delcol[] = { 0, 0, -1, 1 };

        boolean visited[][] = new boolean[graph.length][graph[0].length];
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(i == 0 || i == graph.length - 1 || j == 0 || j == graph[0].length - 1){
                    if(graph[i][j] == 0 && !visited[i][j]){
                        DFS(graph, visited, i, j, delrow, delcol);
                    }
                }
            }
        }

       int ans = 0;

        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(visited[i][j] == false && graph[i][j] == 0){
                   ans++;
                }
            }
            System.out.println();
        }

        System.out.println("Number of converted regions: " + ans);
    }
}
