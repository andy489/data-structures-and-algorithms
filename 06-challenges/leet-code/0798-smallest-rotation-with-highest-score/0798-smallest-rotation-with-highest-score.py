# https://leetcode.com/problems/smallest-rotation-with-highest-score/

class Solution:
    def bestRotation(self, nums: list[int]) -> int:
        n = len(nums)
        change = [0] * n
        for i, v in enumerate(nums):
            lo = (i - v + 1 + n) % n
            hi = i
            change[lo] -= 1
            if lo > hi:
                change[0] -= 1
            if hi + 1 < n:
                change[hi + 1] += 1
        best, score, curr = 0, n, n
        for k in range(1, n):
            curr += change[k]
            if curr > score:
                score = curr
                best = k
        return best
