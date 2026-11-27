// https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/
class Solution {
    public boolean hasExactlyOneConsecutivePair(int n) {
        int pairs = Integer.bitCount(n & (n >> 1));
        return pairs == 1;
    }
}
