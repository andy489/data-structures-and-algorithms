// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
class Solution {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
