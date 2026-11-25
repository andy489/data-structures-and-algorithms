# https://leetcode.com/problems/sliding-puzzle/

from collections import deque

class Solution:
    def slidingPuzzle(self, board: list[list[int]]) -> int:
        neighbors = [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]
        start = ''.join(str(v) for row in board for v in row)
        target = '123450'
        if start == target:
            return 0
        queue = deque([(start, 0)])
        visited = {start}
        while queue:
            curr, steps = queue.popleft()
            zero = curr.index('0')
            for nxt in neighbors[zero]:
                arr = list(curr)
                arr[zero], arr[nxt] = arr[nxt], arr[zero]
                new_state = ''.join(arr)
                if new_state == target:
                    return steps + 1
                if new_state not in visited:
                    visited.add(new_state)
                    queue.append((new_state, steps + 1))
        return -1
