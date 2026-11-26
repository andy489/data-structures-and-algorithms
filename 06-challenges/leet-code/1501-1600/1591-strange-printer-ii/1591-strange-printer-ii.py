# https://leetcode.com/problems/strange-printer-ii/

class Solution:
    def isPrintable(self, targetGrid: list[list[int]]) -> bool:
        m, n = len(targetGrid), len(targetGrid[0])
        C = 60
        top = [m] * (C + 1)
        bottom = [-1] * (C + 1)
        left = [n] * (C + 1)
        right = [-1] * (C + 1)
        for i in range(m):
            for j in range(n):
                c = targetGrid[i][j]
                top[c] = min(top[c], i)
                bottom[c] = max(bottom[c], i)
                left[c] = min(left[c], j)
                right[c] = max(right[c], j)
        deps = [set() for _ in range(C + 1)]
        for c in range(1, C + 1):
            if bottom[c] == -1:
                continue
            for i in range(top[c], bottom[c] + 1):
                for j in range(left[c], right[c] + 1):
                    if targetGrid[i][j] != c:
                        deps[c].add(targetGrid[i][j])
        indegree = [len(deps[c]) for c in range(C + 1)]
        from collections import deque
        queue = deque(c for c in range(1, C + 1) if bottom[c] != -1 and indegree[c] == 0)
        processed = 0
        while queue:
            cur = queue.popleft()
            processed += 1
            for c in range(1, C + 1):
                if cur in deps[c]:
                    indegree[c] -= 1
                    if indegree[c] == 0:
                        queue.append(c)
        used_colors = sum(1 for c in range(1, C + 1) if bottom[c] != -1)
        return processed == used_colors
