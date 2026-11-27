# https://leetcode.com/problems/minimum-operations-to-convert-number/

class Solution:
    def minimumOperations(self, nums: list[int], start: int, goal: int) -> int:
        from collections import deque
        visited = [False] * 1001
        visited[start] = True
        q = deque([(start, 0)])
        while q:
            cur, steps = q.popleft()
            for num in nums:
                for nxt in [cur + num, cur - num, cur ^ num]:
                    if nxt == goal:
                        return steps + 1
                    if 0 <= nxt <= 1000 and not visited[nxt]:
                        visited[nxt] = True
                        q.append((nxt, steps + 1))
        return -1
