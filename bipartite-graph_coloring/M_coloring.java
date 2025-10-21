public class M_coloring {
    static class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[2];
            isEnd = false;
        }
    }

    public static void insert(Trie root, int num) {
        Trie curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new Trie();
            }
            curr = curr.children[bit];
        }
        curr.isEnd = true;
    }

    public static int findMaximumXOR(Trie root, int num) {
        Trie curr = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (curr.children[toggledBit] != null) {
                maxXOR |= (1 << i);
                curr = curr.children[toggledBit];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int arr[] = {7, 9, 8};

        Trie root = new Trie();
        int x = 8;
        for (int i : arr) {
            insert(root, i);
        }

        int ans = findMaximumXOR(root, x);
        System.out.println("Maximum XOR of " + x + " with array elements is: " + ans);
    }
}
