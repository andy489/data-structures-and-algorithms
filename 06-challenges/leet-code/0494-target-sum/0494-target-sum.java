// https://leetcode.com/problems/target-sum/

// Solution: DP (0/1 Knapsack) — O(n · sum) time, O(sum) space
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        // Need subset P where P - (total - P) = target => P = (target + total) / 2
        int sum = target + total;
        if (sum < 0 || sum % 2 != 0) {
            return 0;
        }
        int goal = sum / 2;
        int[] dp = new int[goal + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = goal; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[goal];
    }
}

// Solution 2: DFS with Memoization — O(n · sum) time, O(n · sum) space
class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }

    private int dfs(int[] nums, int idx, int currentSum, int target, Map<String, Integer> memo) {
        if (idx == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        String key = idx + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dfs(nums, idx + 1, currentSum + nums[idx], target, memo)
                   + dfs(nums, idx + 1, currentSum - nums[idx], target, memo);
        memo.put(key, result);
        return result;
    }
}
