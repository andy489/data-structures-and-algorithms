# https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

class Solution:
    def minMoves(self, nums: list[int], limit: int) -> int:
        n = len(nums)
        diff = [0] * (2 * limit + 2)
        for i in range(n // 2):
            a, b = min(nums[i], nums[n - 1 - i]), max(nums[i], nums[n - 1 - i])
            s = nums[i] + nums[n - 1 - i]
            diff[2] += 2
            diff[2 * limit + 1] -= 2
            diff[a + 1] -= 1
            diff[2 * limit + 1] += 1
            diff[s] -= 1
            diff[s + 1] += 1
            diff[b + limit + 1] += 1
            diff[2 * limit + 1] -= 1
        min_moves = float('inf')
        cur = 0
        for t in range(2, 2 * limit + 1):
            cur += diff[t]
            min_moves = min(min_moves, cur)
        return min_moves
