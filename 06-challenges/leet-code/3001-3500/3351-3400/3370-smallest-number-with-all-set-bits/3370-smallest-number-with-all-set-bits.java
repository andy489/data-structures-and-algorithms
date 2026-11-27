// https://leetcode.com/problems/smallest-number-with-all-set-bits/

// Solution: Bit Length Mask — O(log n) time, O(1) space
class Solution {
    public int smallestNumber(int n) {
        int bitLen = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        return (1 << bitLen) - 1;
    }
}
