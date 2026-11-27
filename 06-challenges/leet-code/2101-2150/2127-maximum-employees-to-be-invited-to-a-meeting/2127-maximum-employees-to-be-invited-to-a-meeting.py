# https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
from collections import deque

class Solution:
    def maximumInvitations(self, favorite: list[int]) -> int:
        n = len(favorite)
        in_degree = [0] * n
        reverse_graph = [[] for _ in range(n)]
        for i in range(n):
            in_degree[favorite[i]] += 1
            reverse_graph[favorite[i]].append(i)

        # Topological sort: remove non-cycle nodes
        queue = deque(i for i in range(n) if in_degree[i] == 0)
        on_cycle = [True] * n
        while queue:
            node = queue.popleft()
            on_cycle[node] = False
            nxt = favorite[node]
            in_degree[nxt] -= 1
            if in_degree[nxt] == 0:
                queue.append(nxt)

        def bfs_depth(start, exclude):
            q = deque([(start, 1)])
            max_d = 1
            while q:
                node, d = q.popleft()
                max_d = max(max_d, d)
                for prev in reverse_graph[node]:
                    if prev != exclude and not on_cycle[prev]:
                        q.append((prev, d + 1))
            return max_d

        visited = [False] * n
        max_cycle = 0
        sum_chains = 0

        for i in range(n):
            if on_cycle[i] and not visited[i]:
                cycle_len = 0
                cur = i
                nodes = []
                while not visited[cur]:
                    visited[cur] = True
                    nodes.append(cur)
                    cur = favorite[cur]
                    cycle_len += 1
                if cycle_len == 2:
                    a, b = nodes[0], nodes[1]
                    sum_chains += bfs_depth(a, b) + bfs_depth(b, a)
                else:
                    max_cycle = max(max_cycle, cycle_len)

        return max(max_cycle, sum_chains)
