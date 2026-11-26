# https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/

import bisect

class Solution:
    def minOperations(self, target: list[int], arr: list[int]) -> int:
        pos_in_target = {v: i for i, v in enumerate(target)}
        indices = [pos_in_target[v] for v in arr if v in pos_in_target]
        tails = []
        for idx in indices:
            pos = bisect.bisect_left(tails, idx)
            if pos == len(tails):
                tails.append(idx)
            else:
                tails[pos] = idx
        return len(target) - len(tails)
