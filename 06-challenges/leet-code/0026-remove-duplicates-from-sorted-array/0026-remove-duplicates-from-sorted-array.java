// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
