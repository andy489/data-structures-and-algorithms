// https://leetcode.com/problems/integer-replacement/

// Solution: Greedy / Bit Manipulation — O(log n) time, O(1) space
class Solution {
    public int integerReplacement(int n) {
        int ops = 0;
        long num = n;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else if (num == 3 || (num & 3) == 1) {
                num--;
            } else {
                num++;
            }
            ops++;
        }
        return ops;
    }
}
