# https://leetcode.com/problems/factorial-trailing-zeroes/

# Count factors of 5 — O(log n) time, O(1) space
class Solution:
    def trailingZeroes(self, n: int) -> int:
        count = 0
        while n >= 5:
            n //= 5
            count += n
        return count
