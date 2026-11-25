// https://leetcode.com/problems/minimum-increment-to-make-array-unique/

// Solution: Sort + Greedy — O(n log n) time, O(1) space
class Solution {
    public int minIncrementForUnique(int[] nums) {
        java.util.Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}
