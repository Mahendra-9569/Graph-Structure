import java.util.*;

public class open_the_lock {
    public static List<String> children(String curr) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] chArr = curr.toCharArray();

            chArr[i] = (char)(((chArr[i] - '0' + 1) % 10) + '0');
            ans.add(new String(chArr));
     
            chArr = curr.toCharArray();
            chArr[i] = (char)(((chArr[i] - '0' + 9) % 10) + '0');
            ans.add(new String(chArr));
        }
        return ans;
    }
    
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        
        int steps = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        dead.add("0000");
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                if (curr.equals(target)) return steps;
                
                for (String next : children(curr)) {
                    if (!dead.contains(next) && !dead.contains(next)) {
                        q.offer(next);
                        dead.add(next);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }
}
