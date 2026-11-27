// https://leetcode.com/problems/closest-dessert-cost/

// Solution: Backtracking / DFS — O(n * 3^m) time, O(m) space
class Solution {
    private int ans;
    private int target;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        this.ans = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            dfs(toppingCosts, 0, base);
        }
        return ans;
    }

    private void dfs(int[] toppingCosts, int idx, int cost) {
        if (Math.abs(cost - target) < Math.abs(ans - target)
                || (Math.abs(cost - target) == Math.abs(ans - target) && cost < ans)) {
            ans = cost;
        }
        if (idx == toppingCosts.length || cost >= target) return;
        for (int k = 0; k <= 2; k++) {
            dfs(toppingCosts, idx + 1, cost + k * toppingCosts[idx]);
        }
    }
}
