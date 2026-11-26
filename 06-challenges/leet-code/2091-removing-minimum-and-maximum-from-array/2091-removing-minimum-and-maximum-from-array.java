// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

// Solution: Three-Way Comparison — O(n) time, O(1) space
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, minI = 0, maxI = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minI]) { minI = i; }
            if (nums[i] > nums[maxI]) { maxI = i; }
        }
        int left = Math.max(minI, maxI) + 1;
        int right = n - Math.min(minI, maxI);
        int both = Math.min(minI, maxI) + 1 + n - Math.max(minI, maxI);
        return Math.min(Math.min(left, right), both);
    }
}
