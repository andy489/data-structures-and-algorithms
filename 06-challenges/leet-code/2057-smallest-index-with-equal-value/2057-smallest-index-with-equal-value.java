// https://leetcode.com/problems/smallest-index-with-equal-value/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) { return i; }
        }
        return -1;
    }
}
