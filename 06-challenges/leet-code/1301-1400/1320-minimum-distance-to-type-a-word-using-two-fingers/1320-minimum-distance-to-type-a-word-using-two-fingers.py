# https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

class Solution:
    def minimumDistance(self, word: str) -> int:
        def dist(a, b):
            return 0 if a == 26 else abs(a//6 - b//6) + abs(a%6 - b%6)
        INF = float('inf')
        dp = [[INF]*27 for _ in range(27)]
        dp[26][26] = 0
        for ch in word:
            c = ord(ch) - ord('A')
            nxt = [[INF]*27 for _ in range(27)]
            for f1 in range(27):
                for f2 in range(27):
                    if dp[f1][f2] == INF:
                        continue
                    nxt[c][f2] = min(nxt[c][f2], dp[f1][f2] + dist(f1, c))
                    nxt[f1][c] = min(nxt[f1][c], dp[f1][f2] + dist(f2, c))
            dp = nxt
        return min(dp[f1][f2] for f1 in range(27) for f2 in range(27))
