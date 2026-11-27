# https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

class Solution:
    def minTaps(self, n: int, ranges: list[int]) -> int:
        max_right = [0] * (n + 1)
        for i, r in enumerate(ranges):
            left = max(0, i - r)
            max_right[left] = max(max_right[left], i + r)
        taps = 0
        cur_end = farthest = 0
        for i in range(n + 1):
            farthest = max(farthest, max_right[i])
            if i == cur_end and i < n:
                if farthest == cur_end:
                    return -1
                taps += 1
                cur_end = farthest
        return taps
