// https://leetcode.com/problems/move-zeroes/

// Solution: Two-Pointer (Write Pointer) — O(n) time, O(1) space
class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[write++] = num;
            }
        }
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }
}
