# https://leetcode.com/problems/smallest-number-with-all-set-bits/

class Solution:
    def smallestNumber(self, n: int) -> int:
        bit_len = n.bit_length()
        return (1 << bit_len) - 1
