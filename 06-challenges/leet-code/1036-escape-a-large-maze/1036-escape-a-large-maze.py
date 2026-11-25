# https://leetcode.com/problems/escape-a-large-maze/

class Solution:
    def isEscapePossible(self, blocked: list[list[int]], source: list[int], target: list[int]) -> bool:
        from collections import deque
        blocked_set = {(r, c) for r, c in blocked}
        max_enclosed = len(blocked) * len(blocked) // 2

        def bfs(start, end):
            visited = {tuple(start)}
            q = deque([start])
            while q:
                r, c = q.popleft()
                if [r, c] == end:
                    return True
                if len(visited) > max_enclosed:
                    return True
                for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
                    nr, nc = r+dr, c+dc
                    if 0 <= nr < 10**6 and 0 <= nc < 10**6 and (nr, nc) not in blocked_set and (nr, nc) not in visited:
                        visited.add((nr, nc))
                        q.append([nr, nc])
            return False

        return bfs(source, target) and bfs(target, source)
