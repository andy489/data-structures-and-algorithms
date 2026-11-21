# https://leetcode.com/problems/single-number-ii/

# Solution 1: Bit count per position — O(n) time, O(1) space
class Solution:
    def singleNumber(self, nums: list[int]) -> int:
        ans = 0
        for b in range(32):
            count = sum((n >> b) & 1 for n in nums)
            if count % 3:
                ans |= (1 << b)
        return ans if ans < (1 << 31) else ans - (1 << 32)


# Solution 2: ones/twos bit trick — O(n) time, O(1) space
class Solution2:
    def singleNumber(self, nums: list[int]) -> int:
        ones, twos = 0, 0
        for x in nums:
            ones = (ones ^ x) & ~twos
            twos = (twos ^ x) & ~ones
        return ones
