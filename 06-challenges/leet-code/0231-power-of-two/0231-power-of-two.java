// https://leetcode.com/problems/power-of-two/

// Solution 1: Bit Trick — O(1) time, O(1) space
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

// Solution 2: Lowest Set Bit — O(1) time, O(1) space
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (-n)) == n;
    }
}

// Solution 3: Integer Logarithm — O(1) time, O(1) space
class Solution3 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((1 << 30) % n == 0);
    }
}

// Solution 4: Built-in Popcount — O(1) time, O(1) space
class Solution4 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
