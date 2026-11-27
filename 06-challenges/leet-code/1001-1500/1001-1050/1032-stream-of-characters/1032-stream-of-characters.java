// https://leetcode.com/problems/stream-of-characters/

// Solution: Trie on Reversed Words — O(sum of word lengths) build, O(stream length * max word length) query time, O(sum of word lengths) space
class StreamChecker {
    private int[][] trie;
    private boolean[] isEnd;
    private int trieSize;
    private List<Integer> active;

    public StreamChecker(String[] words) {
        trie = new int[200001][26];
        isEnd = new boolean[200001];
        trieSize = 1;
        active = new ArrayList<>();
        for (String w : words) {
            int node = 0;
            for (int i = w.length() - 1; i >= 0; i--) {
                int c = w.charAt(i) - 'a';
                if (trie[node][c] == 0) {
                    trie[node][c] = trieSize++;
                }
                node = trie[node][c];
            }
            isEnd[node] = true;
        }
    }

    public boolean query(char letter) {
        int c = letter - 'a';
        List<Integer> next = new ArrayList<>();
        next.add(0);
        for (int node : active) {
            if (trie[node][c] != 0) {
                next.add(trie[node][c]);
            }
        }
        active = next;
        for (int node : active) {
            if (isEnd[trie[0][c] == node ? node : node]) {
                // check properly
            }
        }
        // simplified: check end on advanced nodes
        for (int node : active) {
            if (isEnd[node]) return true;
        }
        return false;
    }
}
