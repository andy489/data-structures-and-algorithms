# https://leetcode.com/problems/subarrays-with-k-different-integers/

from collections import defaultdict

class Solution:
    def subarraysWithKDistinct(self, nums: list[int], k: int) -> int:
        def at_most(k):
            count = defaultdict(int)
            res = lo = 0
            for hi, x in enumerate(nums):
                count[x] += 1
                while len(count) > k:
                    count[nums[lo]] -= 1
                    if count[nums[lo]] == 0:
                        del count[nums[lo]]
                    lo += 1
                res += hi - lo + 1
            return res
        return at_most(k) - at_most(k - 1)
