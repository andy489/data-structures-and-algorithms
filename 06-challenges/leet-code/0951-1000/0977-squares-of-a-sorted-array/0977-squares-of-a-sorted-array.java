// https://leetcode.com/problems/squares-of-a-sorted-array/

// Solution: Two Pointers — O(n) time, O(n) space
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int lo = 0, hi = n - 1, pos = n - 1;
        while (lo <= hi) {
            int left = nums[lo] * nums[lo];
            int right = nums[hi] * nums[hi];
            if (left >= right) {
                res[pos--] = left;
                lo++;
            } else {
                res[pos--] = right;
                hi--;
            }
        }
        return res;
    }
}
