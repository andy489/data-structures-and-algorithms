# https://leetcode.com/problems/word-search/

class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        m, n = len(board), len(board[0])

        def dfs(r, c, idx):
            if idx == len(word):
                return True
            if r < 0 or r >= m or c < 0 or c >= n or board[r][c] != word[idx]:
                return False
            tmp, board[r][c] = board[r][c], '#'
            found = (dfs(r + 1, c, idx + 1) or dfs(r - 1, c, idx + 1)
                     or dfs(r, c + 1, idx + 1) or dfs(r, c - 1, idx + 1))
            board[r][c] = tmp
            return found

        return any(dfs(r, c, 0) for r in range(m) for c in range(n))
