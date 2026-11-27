// https://leetcode.com/problems/count-number-of-possible-root-nodes/

class Solution {
    private List<List<Integer>> adj;
    private Set<Long> guessSet;
    private int k;
    private int correct0;
    private int result;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        this.k = k;
        this.result = 0;
        adj = new ArrayList<>();
        guessSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for (int[] g : guesses) {
            guessSet.add((long) g[0] * 100001 + g[1]);
        }

        // Count correct guesses when rooted at 0
        correct0 = dfs1(0, -1);

        // Reroot DP
        dfs2(0, -1, correct0);

        return result;
    }

    private int dfs1(int node, int parent) {
        int cnt = 0;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            if (guessSet.contains((long) node * 100001 + child)) {
                cnt++;
            }
            cnt += dfs1(child, node);
        }
        return cnt;
    }

    private void dfs2(int node, int parent, int curCorrect) {
        if (curCorrect >= k) {
            result++;
        }
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            int next = curCorrect;
            if (guessSet.contains((long) node * 100001 + child)) {
                next--;
            }
            if (guessSet.contains((long) child * 100001 + node)) {
                next++;
            }
            dfs2(child, node, next);
        }
    }
}
