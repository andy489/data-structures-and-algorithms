// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

// Solution: Gray Code — O(log n) time, O(1) space
class Solution {
    public int minimumOneBitOperations(int n) {
        // The minimum operations to reduce n to 0 equals the Gray-code rank of n.
        // Gray-code inverse: g(n) = n XOR (n >> 1) XOR (n >> 2) XOR ... (all shifts)
        int result = 0;
        while (n > 0) {
            result ^= n;
            n >>= 1;
        }
        return result;
    }
}
