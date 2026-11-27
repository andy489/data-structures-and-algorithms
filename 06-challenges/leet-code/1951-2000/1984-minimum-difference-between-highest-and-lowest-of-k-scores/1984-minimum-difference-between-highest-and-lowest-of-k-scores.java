// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

// Solution: Sorting + Sliding Window — O(n log n) time, O(1) space
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
