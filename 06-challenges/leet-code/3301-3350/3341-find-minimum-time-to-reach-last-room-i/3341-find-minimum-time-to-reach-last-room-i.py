# https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/

# Solution: Dijkstra's Algorithm — O(n*m*log(n*m)) time, O(n*m) space
import heapq

class Solution:
    def minTimeToReach(self, moveTime: list[list[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        dist = [[float('inf')] * m for _ in range(n)]
        dist[0][0] = 0
        heap = [(0, 0, 0)]  # (time, row, col)

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while heap:
            t, r, c = heapq.heappop(heap)
            if t > dist[r][c]:
                continue
            if r == n - 1 and c == m - 1:
                return t
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m:
                    arrive = max(t, moveTime[nr][nc]) + 1
                    if arrive < dist[nr][nc]:
                        dist[nr][nc] = arrive
                        heapq.heappush(heap, (arrive, nr, nc))
        return dist[n - 1][m - 1]
