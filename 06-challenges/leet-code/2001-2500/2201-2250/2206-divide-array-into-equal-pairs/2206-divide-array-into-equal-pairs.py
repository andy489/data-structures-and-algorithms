# https://leetcode.com/problems/divide-array-into-equal-pairs/
class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        from collections import Counter
        for count in Counter(nums).values():
            if count % 2 != 0:
                return False
        return True
