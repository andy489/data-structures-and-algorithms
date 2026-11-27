// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/

class Solution {
    public int minOperations(int n) {
        int ops = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                n >>= 1;
            } else if ((n & 3) == 3) {
                // Two consecutive 1s: carry up
                n += 1;
                ops++;
            } else {
                // Single 1: subtract
                n -= 1;
                ops++;
            }
        }
        return ops;
    }
}
