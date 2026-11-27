// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

// Solution: Bit Analysis — O(n * max_bits) time, O(1) space
class Solution {
    public int minOperations(int[] nums) {
        int maxBits = 0, adds = 0;
        for (int x : nums) {
            adds += Integer.bitCount(x);
            int bits = 0;
            while (x > 0) {
                bits++;
                x >>= 1;
            }
            maxBits = Math.max(maxBits, bits);
        }
        return adds + (maxBits > 0 ? maxBits - 1 : 0);
    }
}
