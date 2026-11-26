# https://leetcode.com/problems/parallel-courses-iii/

class Solution:
    def minimumTime(self, n: int, relations: list[list[int]], time: list[int]) -> int:
        from collections import deque
        nxt = [[] for _ in range(n + 1)]
        in_deg = [0] * (n + 1)
        dp = [0] * (n + 1)
        for u, v in relations:
            nxt[u].append(v)
            in_deg[v] += 1
        q = deque()
        for i in range(1, n + 1):
            if in_deg[i] == 0:
                q.append(i)
                dp[i] = time[i - 1]
        while q:
            u = q.popleft()
            for v in nxt[u]:
                dp[v] = max(dp[v], dp[u] + time[v - 1])
                in_deg[v] -= 1
                if in_deg[v] == 0:
                    q.append(v)
        return max(dp)
