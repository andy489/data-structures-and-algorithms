# https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

class Solution:
    def isPossibleDivide(self, nums: list[int], k: int) -> bool:
        from collections import Counter
        if len(nums) % k: return False
        count = Counter(nums)
        for x in sorted(count):
            if count[x] > 0:
                c = count[x]
                for i in range(k):
                    if count[x+i] < c: return False
                    count[x+i] -= c
        return True
