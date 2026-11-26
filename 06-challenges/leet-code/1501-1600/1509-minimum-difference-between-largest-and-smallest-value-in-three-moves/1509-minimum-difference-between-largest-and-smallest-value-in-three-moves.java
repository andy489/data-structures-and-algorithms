// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

// Solution: Sort and Enumerate Removal Patterns — O(n log n) time, O(1) space
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[n - 1 - (3 - i)] - nums[i]);
        }
        return ans;
    }
}
