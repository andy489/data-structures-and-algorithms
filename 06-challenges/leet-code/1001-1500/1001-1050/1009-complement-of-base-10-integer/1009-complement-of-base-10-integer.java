// https://leetcode.com/problems/complement-of-base-10-integer/

// Solution: Bit Mask — O(log n) time, O(1) space
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        return n ^ mask;
    }
}
