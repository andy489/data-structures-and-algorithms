# https://leetcode.com/problems/snakes-and-ladders/

from collections import deque

class Solution:
    def snakesAndLadders(self, board: list) -> int:
        n = len(board)
        target = n * n

        def label_to_rc(label):
            idx = label - 1
            row, col_in_row = divmod(idx, n)
            r = n - 1 - row
            c = col_in_row if row % 2 == 0 else n - 1 - col_in_row
            return r, c

        visited = {1}
        q = deque([(1, 0)])
        while q:
            curr, steps = q.popleft()
            for dice in range(1, 7):
                nxt = curr + dice
                if nxt > target:
                    break
                r, c = label_to_rc(nxt)
                if board[r][c] != -1:
                    nxt = board[r][c]
                if nxt == target:
                    return steps + 1
                if nxt not in visited:
                    visited.add(nxt)
                    q.append((nxt, steps + 1))
        return -1
