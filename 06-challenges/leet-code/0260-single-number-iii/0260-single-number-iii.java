// https://leetcode.com/problems/single-number-iii/

// Solution: Bit Manipulation (XOR + partition) — O(n) time, O(1) space
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int mask = xor & (-xor);
        int a = 0;
        for (int n : nums) {
            if ((n & mask) != 0) {
                a ^= n;
            }
        }
        return new int[]{a, xor ^ a};
    }
}
