// https://leetcode.com/problems/binary-number-with-alternating-bits/

// Solution: Bit Trick — O(1) time, O(1) space
class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}
