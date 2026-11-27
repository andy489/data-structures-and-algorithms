// https://leetcode.com/problems/find-the-most-competitive-subsequence/

// Solution: Monotonic Stack — O(n) time, O(k) space
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && stack[size - 1] > nums[i] && size + (n - i) > k) {
                size--;
            }
            if (size < k) {
                stack[size++] = nums[i];
            }
        }
        return stack;
    }
}
