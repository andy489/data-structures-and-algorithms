# https://leetcode.com/problems/open-the-lock/

from collections import deque

class Solution:
    def openLock(self, deadends: list[str], target: str) -> int:
        dead = set(deadends)
        if '0000' in dead:
            return -1
        if target == '0000':
            return 0
        visited = {'0000'}
        q = deque([('0000', 0)])
        while q:
            state, steps = q.popleft()
            for i in range(4):
                for delta in (1, -1):
                    nxt = state[:i] + str((int(state[i]) + delta) % 10) + state[i+1:]
                    if nxt == target:
                        return steps + 1
                    if nxt not in visited and nxt not in dead:
                        visited.add(nxt)
                        q.append((nxt, steps + 1))
        return -1
