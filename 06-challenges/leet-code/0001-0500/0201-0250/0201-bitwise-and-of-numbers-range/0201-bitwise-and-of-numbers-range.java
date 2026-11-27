// https://leetcode.com/problems/bitwise-and-of-numbers-range/

// Solution: Common Prefix (Bit Shift) — O(log n) time, O(1) space
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }
}

// Solution 2: Brian Kernighan Trick — O(log n) time, O(1) space
class Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }

        return right;
    }
}
