// https://leetcode.com/problems/power-of-three/

// Solution 1: Loop — O(log n) time, O(1) space
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

// Solution 2: Math — O(1) time, O(1) space
class Solution2 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
