# https://leetcode.com/problems/frog-jump/

class Solution:
    def canCross(self, stones: list[int]) -> bool:
        reachable = {stone: set() for stone in stones}
        reachable[0].add(0)
        for stone in stones:
            for k in reachable[stone]:
                for next_jump in (k - 1, k, k + 1):
                    if next_jump > 0 and stone + next_jump in reachable:
                        reachable[stone + next_jump].add(next_jump)
        return bool(reachable[stones[-1]])
