# https://leetcode.com/problems/two-out-of-three/

class Solution:
    def twoOutOfThree(self, nums1: list[int], nums2: list[int], nums3: list[int]) -> list[int]:
        from collections import Counter
        count = Counter()
        for arr in [nums1, nums2, nums3]:
            for x in set(arr):
                count[x] += 1
        return [x for x, c in count.items() if c >= 2]
