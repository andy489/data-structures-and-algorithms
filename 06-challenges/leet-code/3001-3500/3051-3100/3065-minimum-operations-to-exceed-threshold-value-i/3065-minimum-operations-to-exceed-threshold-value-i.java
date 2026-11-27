// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

// Solution: Count — O(n) time, O(1) space
class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int x : nums) { if (x < k) { count++; } }
        return count;
    }
}
