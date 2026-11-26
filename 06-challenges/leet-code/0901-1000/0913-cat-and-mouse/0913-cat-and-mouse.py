# https://leetcode.com/problems/cat-and-mouse/

from collections import deque

class Solution:
    def catMouseGame(self, graph: list) -> int:
        DRAW, MOUSE, CAT = 0, 1, 2
        n = len(graph)
        color = [[[DRAW]*3 for _ in range(n)] for _ in range(n)]
        degree = [[[0]*3 for _ in range(n)] for _ in range(n)]
        for m in range(n):
            for c in range(n):
                degree[m][c][1] = len(graph[m])
                degree[m][c][2] = sum(1 for x in graph[c] if x != 0)
        q = deque()
        for i in range(1, n):
            for t in (1, 2):
                color[0][i][t] = MOUSE
                q.append((0, i, t))
                color[i][i][t] = CAT
                q.append((i, i, t))
        while q:
            m, c, t = q.popleft()
            result = color[m][c][t]
            prevT = 3 - t
            if prevT == 1:
                for pm in graph[m]:
                    if color[pm][c][1] != DRAW:
                        continue
                    if result == MOUSE:
                        color[pm][c][1] = MOUSE
                        q.append((pm, c, 1))
                    else:
                        degree[pm][c][1] -= 1
                        if degree[pm][c][1] == 0:
                            color[pm][c][1] = CAT
                            q.append((pm, c, 1))
            else:
                for pc in graph[c]:
                    if pc == 0 or color[m][pc][2] != DRAW:
                        continue
                    if result == CAT:
                        color[m][pc][2] = CAT
                        q.append((m, pc, 2))
                    else:
                        degree[m][pc][2] -= 1
                        if degree[m][pc][2] == 0:
                            color[m][pc][2] = MOUSE
                            q.append((m, pc, 2))
        return color[1][2][1]
