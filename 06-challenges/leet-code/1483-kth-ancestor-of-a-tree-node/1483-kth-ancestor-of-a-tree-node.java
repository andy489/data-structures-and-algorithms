// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/

// Solution: Binary Lifting — O(n log n) build, O(log n) query time, O(n log n) space
class TreeAncestor {
    private int[][] dp;
    private static final int LOG = 16;
    public TreeAncestor(int n, int[] parent) {
        dp = new int[LOG][n];
        dp[0] = parent;
        for (int j = 1; j < LOG; j++)
            for (int i = 0; i < n; i++)
                dp[j][i] = dp[0][i] == -1 ? -1 : dp[j-1][dp[j-1][i]];
    }
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG && node != -1; j++)
            if ((k >> j & 1) == 1) node = dp[j][node];
        return node;
    }
}
