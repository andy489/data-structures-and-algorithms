// https://leetcode.com/problems/arithmetic-slices/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr = 0, total = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                total += curr;
            } else {
                curr = 0;
            }
        }
        return total;
    }
}
