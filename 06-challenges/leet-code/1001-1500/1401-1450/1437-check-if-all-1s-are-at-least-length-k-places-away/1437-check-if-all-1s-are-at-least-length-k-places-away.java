// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) return false;
                prev = i;
            }
        }
        return true;
    }
}
