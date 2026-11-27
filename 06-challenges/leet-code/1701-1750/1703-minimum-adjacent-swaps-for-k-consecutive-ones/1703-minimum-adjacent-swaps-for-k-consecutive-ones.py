# https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/

class Solution:
    def minMoves(self, nums: list[int], k: int) -> int:
        pos = [i - j for j, i in enumerate(idx for idx, v in enumerate(nums) if v == 1)]
        m = len(pos)
        prefix = [0] * (m + 1)
        for i in range(m):
            prefix[i + 1] = prefix[i] + pos[i]
        result = float('inf')
        for i in range(m - k + 1):
            mid = i + k // 2
            left_cost = pos[mid] * (mid - i) - (prefix[mid] - prefix[i])
            right_cost = (prefix[i + k] - prefix[mid + 1]) - pos[mid] * (i + k - mid - 1)
            result = min(result, left_cost + right_cost)
        return result
