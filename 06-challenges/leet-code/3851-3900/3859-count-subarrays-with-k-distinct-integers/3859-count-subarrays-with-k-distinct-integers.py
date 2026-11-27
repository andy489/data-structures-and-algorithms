# https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/

from collections import defaultdict
from typing import List

class Solution:
    def countSubarrays(self, nums: List[int], k: int, m: int) -> int:
        def at_most(K: int) -> int:
            if K < 0:
                return 0
            freq = defaultdict(int)
            qualified = 0
            count = 0
            l = 0
            for r, v in enumerate(nums):
                freq[v] += 1
                if freq[v] == m:
                    qualified += 1
                while qualified > K:
                    freq[nums[l]] -= 1
                    if freq[nums[l]] == m - 1:
                        qualified -= 1
                    l += 1
                count += r - l + 1
            return count

        return at_most(k) - at_most(k - 1)
