// https://leetcode.com/problems/reverse-bits/

// Bit manipulation — O(1) time, O(1) space
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
