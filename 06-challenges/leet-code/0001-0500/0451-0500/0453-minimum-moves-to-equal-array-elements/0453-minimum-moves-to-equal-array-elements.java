// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

// Solution: Math — O(n) time, O(1) space
class Solution {
    public int minMoves(int[] nums) {
        int minVal = nums[0];
        long total = 0;
        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
            total += num;
        }
        return (int) (total - (long) minVal * nums.length);
    }
}
