# https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
class Solution:
    def highestRankedKItems(self, grid: List[List[int]], pricing: List[int], start: List[int], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        low, high = pricing
        candidates = []
        visited = [[False] * n for _ in range(m)]
        queue = deque([(start[0], start[1], 0)])
        visited[start[0]][start[1]] = True

        while queue:
            r, c, dist = queue.popleft()
            price = grid[r][c]
            if low <= price <= high:
                candidates.append((dist, price, r, c))
            for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] != 0:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))

        candidates.sort()
        return [[r, c] for _, _, r, c in candidates[:k]]
