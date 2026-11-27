# https://leetcode.com/problems/moving-stones-until-consecutive-ii/

class Solution:
    def numMovesStonesII(self, stones: list[int]) -> list[int]:
        stones.sort()
        n = len(stones)
        max_moves = max(stones[-1]-stones[1]-n+2, stones[-2]-stones[0]-n+2)
        min_moves = n
        j = 0
        for i in range(n):
            while j + 1 < n and stones[j+1] - stones[i] < n:
                j += 1
            in_window = j - i + 1
            if in_window == n - 1 and stones[j] - stones[i] == n - 2:
                min_moves = min(min_moves, 2)
            else:
                min_moves = min(min_moves, n - in_window)
        return [min_moves, max_moves]
