# https://leetcode.com/problems/minimum-cost-to-convert-string-i/
class Solution:
    def minimumCost(self, source: str, target: str, original: list[str], changed: list[str], cost: list[int]) -> int:
        INF = float('inf')
        dist = [[INF] * 26 for _ in range(26)]
        for i in range(26):
            dist[i][i] = 0
        for o, c, w in zip(original, changed, cost):
            f, t = ord(o) - ord('a'), ord(c) - ord('a')
            dist[f][t] = min(dist[f][t], w)
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        total = 0
        for s, t in zip(source, target):
            f, to = ord(s) - ord('a'), ord(t) - ord('a')
            if dist[f][to] == INF:
                return -1
            total += dist[f][to]
        return total
