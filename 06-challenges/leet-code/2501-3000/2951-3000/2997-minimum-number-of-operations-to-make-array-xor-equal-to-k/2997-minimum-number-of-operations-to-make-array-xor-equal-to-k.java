// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
class Solution {
    public int minOperations(int[] nums, int k) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }
        return Integer.bitCount(xorAll ^ k);
    }
}
