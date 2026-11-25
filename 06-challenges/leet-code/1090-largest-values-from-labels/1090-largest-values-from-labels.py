# https://leetcode.com/problems/largest-values-from-labels/

class Solution:
    def largestValsFromLabels(self, values: list[int], labels: list[int], numWanted: int, useLimit: int) -> int:
        from collections import defaultdict
        pairs = sorted(zip(values, labels), reverse=True)
        label_count = defaultdict(int)
        total, chosen = 0, 0
        for v, l in pairs:
            if chosen >= numWanted:
                break
            if label_count[l] < useLimit:
                total += v
                label_count[l] += 1
                chosen += 1
        return total
