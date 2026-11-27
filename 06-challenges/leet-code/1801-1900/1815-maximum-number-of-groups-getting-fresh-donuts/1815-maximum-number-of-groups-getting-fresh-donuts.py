# https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/

from functools import lru_cache

class Solution:
    def maxHappyGroups(self, batchSize: int, groups: list[int]) -> int:
        freq = [0] * batchSize
        for g in groups:
            freq[g % batchSize] += 1

        happy = freq[0]
        freq[0] = 0

        for i in range(1, batchSize // 2 + 1):
            j = batchSize - i
            if i == j:
                happy += freq[i] // 2
                freq[i] %= 2
            else:
                pairs = min(freq[i], freq[j])
                happy += pairs
                freq[i] -= pairs
                freq[j] -= pairs

        freq = tuple(freq)

        @lru_cache(maxsize=None)
        def dp(state, cur):
            best = 0
            state = list(state)
            for i in range(1, batchSize):
                if state[i] > 0:
                    state[i] -= 1
                    nxt = (cur + i) % batchSize
                    gain = 1 if nxt == 0 else 0
                    best = max(best, gain + dp(tuple(state), nxt))
                    state[i] += 1
            return best

        return happy + dp(freq, 0)
