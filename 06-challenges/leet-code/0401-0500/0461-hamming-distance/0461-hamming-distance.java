// https://leetcode.com/problems/hamming-distance/

// Solution: XOR + Bit Count — O(1) time, O(1) space
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
