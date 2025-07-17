import java.util.LinkedList;

import java.util.Queue;
public class LittleTigers {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]){
        int graph[][] = new int[8][8];
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1, 1, 0, 0, -1, -1, -1, 1, 1};   
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2, 0, -1, 1, 0, 1, -1, 1, -1};
        
        int st = 3;
        int en = 3;
        graph[3][3] = 1;

        int MinStep = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st, en));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair node = q.poll();
                int x1 = node.x;
                int y1 = node.y;

                for(int j = 0; j < 16; j++){
                    int x2 = x1 + dx[j];
                    int y2 = y1 + dy[j];

                    if(x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8 && graph[x2][y2] == 0){
                        if(x2 == 7 && y2 == 7){
                            System.out.println("Minimum steps to reach destination: " + (MinStep + 1));
                            return;
                        }
                        graph[x2][y2] = 1;
                        q.add(new Pair(x2, y2));
                    }
                }
            }
            MinStep++;
        }

        System.out.println("Destination not reachable");
    }
}
