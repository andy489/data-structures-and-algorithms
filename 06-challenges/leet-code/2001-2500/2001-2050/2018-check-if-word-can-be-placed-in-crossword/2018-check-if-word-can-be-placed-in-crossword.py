# https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

class Solution:
    def placeWordInCrossword(self, board: list[list[str]], word: str) -> bool:
        m, n, L = len(board), len(board[0]), len(word)
        def fits(cells):
            if len(cells) != L:
                return False
            for w in [word, word[::-1]]:
                if all(c == ' ' or c == ch for c, ch in zip(cells, w)):
                    return True
            return False
        for r in range(m):
            run = []
            for c in range(n + 1):
                if c < n and board[r][c] != '#':
                    run.append(board[r][c])
                else:
                    if fits(run):
                        return True
                    run = []
        for c in range(n):
            run = []
            for r in range(m + 1):
                if r < m and board[r][c] != '#':
                    run.append(board[r][c])
                else:
                    if fits(run):
                        return True
                    run = []
        return False
