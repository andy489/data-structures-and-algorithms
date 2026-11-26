# https://leetcode.com/problems/valid-arrangement-of-pairs/

class Solution:
    def validArrangement(self, pairs: list[list[int]]) -> list[list[int]]:
        from collections import defaultdict, deque
        graph = defaultdict(deque)
        out_deg, in_deg = defaultdict(int), defaultdict(int)
        for s, e in pairs:
            graph[s].append(e)
            out_deg[s] += 1
            in_deg[e] += 1
        start = pairs[0][0]
        for node in out_deg:
            if out_deg[node] - in_deg[node] == 1:
                start = node
                break
        path = []
        stack = [start]
        while stack:
            u = stack[-1]
            if graph[u]:
                stack.append(graph[u].popleft())
            else:
                path.append(stack.pop())
        path.reverse()
        return [[path[i], path[i+1]] for i in range(len(path)-1)]
