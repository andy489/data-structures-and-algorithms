// https://leetcode.com/problems/maximum-xor-product/

// Solution: Greedy Bit-by-Bit — O(n) time, O(1) space
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long mod = 1_000_000_007L;
        for (int i = n - 1; i >= 0; i--) {
            long bitA = (a >> i) & 1;
            long bitB = (b >> i) & 1;
            if (bitA == bitB) {
                a |= (1L << i);
                b |= (1L << i);
            } else {
                if (a < b) {
                    a |= (1L << i);
                    b &= ~(1L << i);
                } else {
                    b |= (1L << i);
                    a &= ~(1L << i);
                }
            }
        }
        return (int) ((a % mod) * (b % mod) % mod);
    }
}
