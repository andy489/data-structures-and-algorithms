# https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution:
    def findTheCity(self, n: int, edges, distanceThreshold: int) -> int:
        INF = float('inf')
        dist = [[INF]*n for _ in range(n)]
        for i in range(n):
            dist[i][i] = 0
        for u, v, w in edges:
            dist[u][v] = dist[v][u] = w
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        ans, min_cnt = -1, n+1
        for i in range(n):
            cnt = sum(1 for j in range(n) if i != j and dist[i][j] <= distanceThreshold)
            if cnt <= min_cnt:
                min_cnt, ans = cnt, i
        return ans
