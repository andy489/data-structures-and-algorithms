# https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/
class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: list[list[int]]) -> int:
        INF = float('inf')
        ans = 0
        for mask in range(1 << n):
            dist = [[INF] * n for _ in range(n)]
            for i in range(n):
                dist[i][i] = 0
            for u, v, w in roads:
                if not (mask >> u & 1) and not (mask >> v & 1):
                    if w < dist[u][v]:
                        dist[u][v] = w
                    if w < dist[v][u]:
                        dist[v][u] = w
            for k in range(n):
                if mask >> k & 1:
                    continue
                for i in range(n):
                    if mask >> i & 1:
                        continue
                    for j in range(n):
                        if mask >> j & 1:
                            continue
                        if dist[i][k] + dist[k][j] < dist[i][j]:
                            dist[i][j] = dist[i][k] + dist[k][j]
            valid = True
            for i in range(n):
                if mask >> i & 1:
                    continue
                for j in range(i + 1, n):
                    if mask >> j & 1:
                        continue
                    if dist[i][j] > maxDistance:
                        valid = False
                        break
                if not valid:
                    break
            if valid:
                ans += 1
        return ans
