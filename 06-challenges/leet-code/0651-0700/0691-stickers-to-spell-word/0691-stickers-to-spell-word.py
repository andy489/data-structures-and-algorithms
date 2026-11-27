# https://leetcode.com/problems/stickers-to-spell-word/

class Solution:
    def minStickers(self, stickers: list, target: str) -> int:
        t = len(target)
        total = 1 << t
        dp = [float('inf')] * total
        dp[0] = 0
        for mask in range(total):
            if dp[mask] == float('inf'):
                continue
            for sticker in stickers:
                freq = {}
                for c in sticker:
                    freq[c] = freq.get(c, 0) + 1
                new_mask = mask
                for i in range(t):
                    if not (new_mask >> i & 1):
                        c = target[i]
                        if freq.get(c, 0) > 0:
                            freq[c] -= 1
                            new_mask |= (1 << i)
                dp[new_mask] = min(dp[new_mask], dp[mask] + 1)
        return dp[total - 1] if dp[total - 1] != float('inf') else -1
