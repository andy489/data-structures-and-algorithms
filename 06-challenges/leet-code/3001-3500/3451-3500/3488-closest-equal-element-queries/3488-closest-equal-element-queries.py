# https://leetcode.com/problems/closest-equal-element-queries/

import bisect
from collections import defaultdict

class Solution:
    def solveQueries(self, nums: list[int], queries: list[int]) -> list[int]:
        n = len(nums)
        positions = defaultdict(list)
        for i, v in enumerate(nums):
            positions[v].append(i)

        answer = []
        for idx in queries:
            v = nums[idx]
            pos = positions[v]
            if len(pos) == 1:
                answer.append(-1)
                continue
            p = bisect.bisect_left(pos, idx)
            best = float('inf')
            for neighbor in [(p - 1) % len(pos), (p + 1) % len(pos)]:
                d = abs(pos[neighbor] - idx)
                best = min(best, d, n - d)
            answer.append(best)
        return answer
