# https://leetcode.com/problems/find-longest-awesome-substring/

class Solution:
    def longestAwesome(self, s: str) -> int:
        first_seen = [-2] * (1 << 10)
        first_seen[0] = -1
        mask = 0
        best = 0
        for i, c in enumerate(s):
            mask ^= 1 << int(c)
            if first_seen[mask] != -2:
                best = max(best, i - first_seen[mask])
            else:
                first_seen[mask] = i
            for d in range(10):
                flipped = mask ^ (1 << d)
                if first_seen[flipped] != -2:
                    best = max(best, i - first_seen[flipped])
        return best
