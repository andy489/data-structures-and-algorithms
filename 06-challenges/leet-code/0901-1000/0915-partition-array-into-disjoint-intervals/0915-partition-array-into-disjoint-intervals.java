// https://leetcode.com/problems/partition-array-into-disjoint-intervals/

// Solution: Two-Pass Scan — O(n) time, O(n) space
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        int leftMax = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i - 1]);
            if (leftMax <= minRight[i]) {
                return i;
            }
        }
        return n - 1;
    }
}
