# https://leetcode.com/problems/frog-position-after-t-seconds/

from collections import defaultdict, deque

class Solution:
    def frogPosition(self, n: int, edges, t: int, target: int) -> float:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v); adj[v].append(u)
        prob = [0.0] * (n+1)
        prob[1] = 1.0
        visited = {1}
        q = deque([1])
        for _ in range(t):
            if not q:
                break
            for _ in range(len(q)):
                cur = q.popleft()
                unvisited = [nb for nb in adj[cur] if nb not in visited]
                if not unvisited:
                    continue
                for nb in unvisited:
                    visited.add(nb)
                    prob[nb] = prob[cur] / len(unvisited)
                    q.append(nb)
                prob[cur] = 0
        return prob[target]
