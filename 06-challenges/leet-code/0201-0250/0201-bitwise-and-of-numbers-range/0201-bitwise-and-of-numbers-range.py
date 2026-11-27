# https://leetcode.com/problems/bitwise-and-of-numbers-range/

# Solution: Common Prefix (Bit Shift) — O(log n) time, O(1) space
class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        shift = 0

        while left != right:
            left >>= 1
            right >>= 1
            shift += 1

        return left << shift

# Solution 2: Brian Kernighan Trick — O(log n) time, O(1) space
class Solution2:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        while right > left:
            right &= right - 1

        return right
