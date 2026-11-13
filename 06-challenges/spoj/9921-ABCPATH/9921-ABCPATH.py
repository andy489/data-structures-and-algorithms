# https://www.spoj.com/problems/ABCPATH/

import sys
input = sys.stdin.readline

dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

class Solution:
    def __init__(self):
        self.H = self.W = 0
        self.grid = []
        self.dp = []

    def read(self):
        self.H, self.W = map(int, input().split())
        if self.H == 0 and self.W == 0:
            return False
        self.grid = [input().strip() for _ in range(self.H)]
        self.dp = [[1]*self.W for _ in range(self.H)]
        return True

    def solve(self):
        H, W, grid, dp = self.H, self.W, self.grid, self.dp
        for c in range(ord('Y'), ord('A')-1, -1):
            for i in range(H):
                for j in range(W):
                    if ord(grid[i][j]) != c:
                        continue
                    for d in range(8):
                        ni, nj = i+dx[d], j+dy[d]
                        if 0 <= ni < H and 0 <= nj < W and ord(grid[ni][nj]) == c+1:
                            dp[i][j] = max(dp[i][j], 1+dp[ni][nj])
        return max(dp[i][j] for i in range(H) for j in range(W) if grid[i][j] == 'A')

s = Solution()
cas = 1
while s.read():
    print(f"Case {cas}: {s.solve()}")
    cas += 1
