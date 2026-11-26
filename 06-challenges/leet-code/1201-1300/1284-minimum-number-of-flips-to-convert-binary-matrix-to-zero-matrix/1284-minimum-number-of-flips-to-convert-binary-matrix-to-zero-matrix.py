# https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

from collections import deque
class Solution:
    def minFlips(self, mat: list[list[int]]) -> int:
        m, n = len(mat), len(mat[0])
        start = sum(mat[i][j] << (i*n+j) for i in range(m) for j in range(n))
        if not start: return 0
        flip_masks = []
        for i in range(m):
            for j in range(n):
                mask = 0
                for di, dj in [(0,0),(-1,0),(1,0),(0,-1),(0,1)]:
                    ni, nj = i+di, j+dj
                    if 0<=ni<m and 0<=nj<n: mask |= 1<<(ni*n+nj)
                flip_masks.append(mask)
        visited = {start}
        q = deque([start])
        steps = 0
        while q:
            steps += 1
            for _ in range(len(q)):
                cur = q.popleft()
                for fm in flip_masks:
                    nxt = cur ^ fm
                    if not nxt: return steps
                    if nxt not in visited: visited.add(nxt); q.append(nxt)
        return -1
