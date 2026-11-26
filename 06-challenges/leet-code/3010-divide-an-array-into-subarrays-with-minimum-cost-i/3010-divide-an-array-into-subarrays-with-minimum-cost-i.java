// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

// Solution: Greedy (Two Smallest) — O(n) time, O(1) space
class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) { min2 = min1; min1 = nums[i]; }
            else if (nums[i] < min2) { min2 = nums[i]; }
        }
        return nums[0] + min1 + min2;
    }
}
