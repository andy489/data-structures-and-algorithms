// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

// Solution: Median — O(n log n) time, O(1) space
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
