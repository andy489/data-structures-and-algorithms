# https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

from collections import Counter

class Solution:
    def numTriplets(self, nums1: list[int], nums2: list[int]) -> int:
        def count(a: list[int], b: list[int]) -> int:
            freq = Counter(b)
            total = 0
            for x in a:
                sq = x * x
                for bv, cnt in freq.items():
                    if sq % bv == 0:
                        pair = sq // bv
                        if pair != bv:
                            total += cnt * freq.get(pair, 0)
                        else:
                            total += cnt * (cnt - 1)
            return total // 2

        return count(nums1, nums2) + count(nums2, nums1)
