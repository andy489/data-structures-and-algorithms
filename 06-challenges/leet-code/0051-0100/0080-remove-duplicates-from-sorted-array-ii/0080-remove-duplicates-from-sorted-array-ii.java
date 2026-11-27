// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (k < 2 || x != nums[k - 2]) {
                nums[k++] = x;
            }
        }
        return k;
    }
}
