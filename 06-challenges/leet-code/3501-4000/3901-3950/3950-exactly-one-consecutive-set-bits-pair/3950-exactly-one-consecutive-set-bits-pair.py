# https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/
class Solution:
    def hasExactlyOneConsecutivePair(self, n: int) -> bool:
        return bin(n & (n >> 1)).count('1') == 1
