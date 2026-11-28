// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/

// Solution: Brute Force — O(n^3) time, O(1) space
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        minSum = Math.min(minSum, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
