# https://leetcode.com/problems/number-of-1-bits/

# Brian Kernighan — O(k) time, O(1) space
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n:
            n &= n - 1
            count += 1
        return count
