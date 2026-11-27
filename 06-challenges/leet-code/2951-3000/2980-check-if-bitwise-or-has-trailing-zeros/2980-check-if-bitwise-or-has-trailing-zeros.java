// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/
class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                evenCount++;
            }
        }
        return evenCount >= 2;
    }
}
