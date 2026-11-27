# https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
class Solution:
    def maximumTop(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if n == 1:
            return nums[0] if k % 2 == 0 else -1
        if k == 0:
            return nums[0]
        best = -1
        limit = min(k - 1, n)
        for i in range(limit):
            best = max(best, nums[i])
        if k < n:
            best = max(best, nums[k])
        return best
