// https://leetcode.com/problems/sort-array-by-parity-ii/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        for (int even = 0; even < nums.length; even += 2) {
            if (nums[even] % 2 == 1) {
                while (nums[odd] % 2 == 1) {
                    odd += 2;
                }
                int tmp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = tmp;
            }
        }
        return nums;
    }
}
