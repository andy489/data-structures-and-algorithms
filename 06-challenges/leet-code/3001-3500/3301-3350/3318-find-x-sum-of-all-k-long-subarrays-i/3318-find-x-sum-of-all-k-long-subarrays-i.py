# https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

from typing import List
from collections import Counter


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        answer = []
        for i in range(n - k + 1):
            window = nums[i:i + k]
            freq = Counter(window)
            top_x = sorted(freq.items(), key=lambda p: (p[1], p[0]), reverse=True)[:x]
            answer.append(sum(val * cnt for val, cnt in top_x))
        return answer
