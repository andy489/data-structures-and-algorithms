# https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/

class Solution:
    def tilingRectangle(self, n: int, m: int) -> int:
        self.res = n * m
        def dfs(sky, count):
            if count >= self.res: return
            min_h = min(sky)
            if min_h == n: self.res = count; return
            pos = sky.index(min_h)
            max_sz = min(n - min_h, m - pos)
            for sz in range(max_sz, 0, -1):
                if all(sky[pos+j] == min_h for j in range(sz)):
                    old = sky[:]
                    for j in range(sz): sky[pos+j] += sz
                    dfs(sky, count+1)
                    sky[:] = old
        dfs([0]*m, 0)
        return self.res
