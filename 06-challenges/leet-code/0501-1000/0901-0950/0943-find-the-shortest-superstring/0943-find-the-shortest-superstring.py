# https://leetcode.com/problems/find-the-shortest-superstring/

class Solution:
    def shortestSuperstring(self, words: list) -> str:
        n = len(words)
        overlap = [[0]*n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i != j:
                    max_ov = min(len(words[i]), len(words[j]))
                    for ov in range(max_ov, 0, -1):
                        if words[i].endswith(words[j][:ov]):
                            overlap[i][j] = ov
                            break
        INF = float('inf')
        dp = [[INF]*n for _ in range(1 << n)]
        parent = [[-1]*n for _ in range(1 << n)]
        for i in range(n):
            dp[1<<i][i] = len(words[i])
        for mask in range(1, 1 << n):
            for last in range(n):
                if not (mask >> last & 1) or dp[mask][last] == INF:
                    continue
                for nxt in range(n):
                    if mask >> nxt & 1:
                        continue
                    new_mask = mask | (1 << nxt)
                    new_len = dp[mask][last] + len(words[nxt]) - overlap[last][nxt]
                    if new_len < dp[new_mask][nxt]:
                        dp[new_mask][nxt] = new_len
                        parent[new_mask][nxt] = last
        full = (1 << n) - 1
        last = min(range(n), key=lambda i: dp[full][i])
        order, mask = [], full
        for _ in range(n):
            order.append(last)
            prev = parent[mask][last]
            mask ^= 1 << last
            last = prev
        order.reverse()
        result = words[order[0]]
        for i in range(1, n):
            result += words[order[i]][overlap[order[i-1]][order[i]]:]
        return result
