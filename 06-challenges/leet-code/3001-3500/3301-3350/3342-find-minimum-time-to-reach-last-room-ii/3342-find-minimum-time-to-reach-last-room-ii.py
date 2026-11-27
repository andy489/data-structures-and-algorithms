# https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/

# Solution: Dijkstra with Alternating Step Cost — O(n*m*log(n*m)) time, O(n*m) space
import heapq

class Solution:
    def minTimeToReach(self, moveTime: list[list[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        # dist[r][c][p]: min time at (r,c) with move parity p
        dist = [[[float('inf')] * 2 for _ in range(m)] for _ in range(n)]
        dist[0][0][0] = 0
        heap = [(0, 0, 0, 0)]  # (time, row, col, parity)

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while heap:
            t, r, c, p = heapq.heappop(heap)
            if t > dist[r][c][p]:
                continue
            if r == n - 1 and c == m - 1:
                return t
            cost = 1 if p == 0 else 2
            np = 1 - p
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m:
                    arrive = max(t, moveTime[nr][nc]) + cost
                    if arrive < dist[nr][nc][np]:
                        dist[nr][nc][np] = arrive
                        heapq.heappush(heap, (arrive, nr, nc, np))
        return min(dist[n - 1][m - 1])
