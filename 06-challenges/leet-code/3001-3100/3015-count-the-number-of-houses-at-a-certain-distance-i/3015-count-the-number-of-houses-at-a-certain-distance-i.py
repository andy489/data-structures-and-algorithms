# https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/

class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> list[int]:
        from collections import deque, defaultdict
        adj = defaultdict(list)
        for i in range(1, n):
            adj[i].append(i+1); adj[i+1].append(i)
        if x != y:
            adj[x].append(y); adj[y].append(x)
        answer = [0] * n
        for src in range(1, n+1):
            dist = [-1] * (n+1)
            dist[src] = 0
            q = deque([src])
            while q:
                u = q.popleft()
                for v in adj[u]:
                    if dist[v] == -1:
                        dist[v] = dist[u] + 1
                        q.append(v)
            for dst in range(1, n+1):
                if dst != src and 1 <= dist[dst] <= n:
                    answer[dist[dst]-1] += 1
        return answer
