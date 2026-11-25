# https://leetcode.com/problems/shortest-path-to-get-all-keys/

from collections import deque

class Solution:
    def shortestPathAllKeys(self, grid: list[str]) -> int:
        m, n = len(grid), len(grid[0])
        start_r = start_c = 0
        all_keys = 0
        for r in range(m):
            for c in range(n):
                ch = grid[r][c]
                if ch == '@':
                    start_r, start_c = r, c
                elif 'a' <= ch <= 'f':
                    all_keys |= 1 << (ord(ch) - ord('a'))

        queue = deque([(start_r, start_c, 0, 0)])
        visited = {(start_r, start_c, 0)}
        for r, c, keys, steps in queue:
            if keys == all_keys:
                return steps
            for dr, dc in ((0,1),(0,-1),(1,0),(-1,0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n:
                    ch = grid[nr][nc]
                    if ch == '#':
                        continue
                    if 'A' <= ch <= 'F' and not (keys & (1 << (ord(ch) - ord('A')))):
                        continue
                    nkeys = keys | (1 << (ord(ch) - ord('a'))) if 'a' <= ch <= 'f' else keys
                    if (nr, nc, nkeys) not in visited:
                        visited.add((nr, nc, nkeys))
                        queue.append((nr, nc, nkeys, steps + 1))
        return -1
