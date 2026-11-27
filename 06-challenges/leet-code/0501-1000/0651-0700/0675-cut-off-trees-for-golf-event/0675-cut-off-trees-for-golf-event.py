# https://leetcode.com/problems/cut-off-trees-for-golf-event/

from collections import deque

class Solution:
    def cutOffTree(self, forest: list) -> int:
        m, n = len(forest), len(forest[0])
        trees = sorted(
            (forest[i][j], i, j)
            for i in range(m) for j in range(n) if forest[i][j] > 1
        )

        def bfs(sr, sc, tr, tc):
            if sr == tr and sc == tc:
                return 0
            visited = [[False] * n for _ in range(m)]
            visited[sr][sc] = True
            queue = deque([(sr, sc, 0)])
            while queue:
                r, c, dist = queue.popleft()
                for dr, dc in ((0,1),(0,-1),(1,0),(-1,0)):
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and forest[nr][nc] != 0:
                        if nr == tr and nc == tc:
                            return dist + 1
                        visited[nr][nc] = True
                        queue.append((nr, nc, dist + 1))
            return -1

        sr = sc = total = 0
        for _, tr, tc in trees:
            steps = bfs(sr, sc, tr, tc)
            if steps == -1:
                return -1
            total += steps
            sr, sc = tr, tc
        return total
