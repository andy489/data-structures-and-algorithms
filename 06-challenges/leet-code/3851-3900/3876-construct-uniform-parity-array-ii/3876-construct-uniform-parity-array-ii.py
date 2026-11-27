# https://leetcode.com/problems/construct-uniform-parity-array-ii/

class Solution:
    def constructArray(self, nums1: list[int]) -> bool:
        min_odd = float('inf')
        min_even = float('inf')
        for x in nums1:
            if x % 2 != 0:
                min_odd = min(min_odd, x)
            else:
                min_even = min(min_even, x)
        all_even = min_odd == float('inf')
        all_odd = min_even == float('inf') or (min_odd != float('inf') and min_odd < min_even)
        return all_even or all_odd
