# https://leetcode.com/problems/stone-game-ix/

class Solution:
    def stoneGameIX(self, stones: list[int]) -> bool:
        cnt = [0, 0, 0]
        for s in stones:
            cnt[s % 3] += 1
        if cnt[0] % 2 == 0:
            return cnt[1] > 0 and cnt[2] > 0
        return abs(cnt[1] - cnt[2]) > 2
