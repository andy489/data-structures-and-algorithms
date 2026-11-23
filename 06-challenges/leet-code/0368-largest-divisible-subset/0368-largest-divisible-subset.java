// https://leetcode.com/problems/largest-divisible-subset/

// Solution: Sort + DP — O(n²) time, O(n) space
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = parent[i]) {
            result.add(nums[i]);
            if (parent[i] == -1) {
                break;
            }
        }
        return result;
    }
}
