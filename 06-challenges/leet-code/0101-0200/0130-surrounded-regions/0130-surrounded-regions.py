# https://leetcode.com/problems/surrounded-regions/

# Solution 1: DFS from Border — O(m·n) time, O(m·n) space
class Solution:
    def solve(self, board: list[list[str]]) -> None:
        m, n = len(board), len(board[0])

        def dfs(i: int, j: int) -> None:
            if i < 0 or i >= m or j < 0 or j >= n or board[i][j] != 'O':
                return
            board[i][j] = 'S'
            dfs(i + 1, j); dfs(i - 1, j)
            dfs(i, j + 1); dfs(i, j - 1)

        for i in range(m):
            if board[i][0] == 'O': dfs(i, 0)
            if board[i][n - 1] == 'O': dfs(i, n - 1)
        for j in range(n):
            if board[0][j] == 'O': dfs(0, j)
            if board[m - 1][j] == 'O': dfs(m - 1, j)

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'S':
                    board[i][j] = 'O'


# Solution 2: BFS from Border — O(m·n) time, O(m·n) space
from collections import deque

class Solution2:
    def solve(self, board: list[list[str]]) -> None:
        m, n = len(board), len(board[0])
        queue = deque()
        for i in range(m):
            for j in [0, n - 1]:
                if board[i][j] == 'O':
                    board[i][j] = 'S'
                    queue.append((i, j))
        for j in range(1, n - 1):
            for i in [0, m - 1]:
                if board[i][j] == 'O':
                    board[i][j] = 'S'
                    queue.append((i, j))
        while queue:
            i, j = queue.popleft()
            for ni, nj in ((i+1,j),(i-1,j),(i,j+1),(i,j-1)):
                if 0 <= ni < m and 0 <= nj < n and board[ni][nj] == 'O':
                    board[ni][nj] = 'S'
                    queue.append((ni, nj))
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'S':
                    board[i][j] = 'O'
