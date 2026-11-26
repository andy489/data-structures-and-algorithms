# https://leetcode.com/problems/jump-game-iv/

from collections import deque, defaultdict

class Solution:
    def minJumps(self, arr: list[int]) -> int:
        n = len(arr)
        if n == 1:
            return 0
        same = defaultdict(list)
        for i, v in enumerate(arr):
            same[v].append(i)
        visited = {0}
        q = deque([0])
        steps = 0
        while q:
            steps += 1
            for _ in range(len(q)):
                cur = q.popleft()
                candidates = [cur-1, cur+1] + same.pop(arr[cur], [])
                for nxt in candidates:
                    if nxt == n-1:
                        return steps
                    if 0 <= nxt < n and nxt not in visited:
                        visited.add(nxt)
                        q.append(nxt)
        return steps
