# https://leetcode.com/problems/jump-game-iii/

from collections import deque

class Solution:
    def canReach(self, arr: list[int], start: int) -> bool:
        n = len(arr)
        visited = set()
        q = deque([start])
        while q:
            i = q.popleft()
            if i in visited:
                continue
            visited.add(i)
            if arr[i] == 0:
                return True
            for nxt in [i + arr[i], i - arr[i]]:
                if 0 <= nxt < n and nxt not in visited:
                    q.append(nxt)
        return False
