// https://leetcode.com/problems/count-non-adjacent-subsets-in-a-rooted-tree/
class Solution {
    static final int MOD = 1_000_000_007;
    int k;
    List<Integer>[] children;
    // dp[node] = long[2][k]: dp[node][inc][rem]
    long[][][] dp;

    public int countNonAdjacentSubsets(int[] parent, int[] nums, int k) {
        this.k = k;
        int n = parent.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        dp = new long[n][2][k];
        dfs(0, nums);
        // answer: sum of valid subsets = dp[0][0][0] + dp[0][1][0] - 1 (subtract empty set)
        long ans = (dp[0][0][0] + dp[0][1][0] - 1 + MOD) % MOD;
        return (int) ans;
    }

    void dfs(int node, int[] nums) {
        int rem = nums[node] % k;
        // base: just this node alone
        dp[node][1][rem] = 1;
        dp[node][0][0] = 1; // empty subset for this subtree

        for (int child : children[node]) {
            dfs(child, nums);
            // merge child into node
            long[][] merged = new long[2][k];
            for (int incN = 0; incN <= 1; incN++) {
                for (int remN = 0; remN < k; remN++) {
                    if (dp[node][incN][remN] == 0) {
                        continue;
                    }
                    // child not included (incN doesn't restrict child)
                    for (int remC = 0; remC < k; remC++) {
                        long childWays = (dp[child][0][remC] + dp[child][1][remC]) % MOD;
                        int newRem = (remN + remC) % k;
                        merged[incN][newRem] = (merged[incN][newRem] + dp[node][incN][remN] * childWays) % MOD;
                    }
                    if (incN == 1) {
                        // node is included, child cannot be included
                        // undo the childWays that includes child
                        for (int remC = 0; remC < k; remC++) {
                            int newRem = (remN + remC) % k;
                            merged[incN][newRem] = (merged[incN][newRem] - dp[node][incN][remN] * dp[child][1][remC] % MOD + MOD) % MOD;
                        }
                    }
                }
            }
            dp[node] = merged;
        }
    }
}
