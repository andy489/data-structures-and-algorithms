// https://leetcode.com/problems/power-of-four/

// Solution 1: Bit Manipulation — O(1) time, O(1) space
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}

// Solution 2: Loop — O(log n) time, O(1) space
class Solution2 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
