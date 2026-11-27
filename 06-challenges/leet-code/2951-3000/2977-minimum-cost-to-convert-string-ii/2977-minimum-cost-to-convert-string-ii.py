# https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
class Solution:
    def minimumCost(self, source: str, target: str, original: list[str], changed: list[str], cost: list[int]) -> int:
        INF = float('inf')
        # Assign IDs to distinct substrings
        id_map = {}
        for s in original + changed:
            if s not in id_map:
                id_map[s] = len(id_map)
        K = len(id_map)
        dist = [[INF] * K for _ in range(K)]
        for i in range(K):
            dist[i][i] = 0
        for o, c, w in zip(original, changed, cost):
            f, t = id_map[o], id_map[c]
            dist[f][t] = min(dist[f][t], w)
        for k in range(K):
            for i in range(K):
                for j in range(K):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        n = len(source)
        dp = [INF] * (n + 1)
        dp[0] = 0
        for i in range(n):
            if dp[i] == INF:
                continue
            if source[i] == target[i]:
                dp[i + 1] = min(dp[i + 1], dp[i])
            for sub, fid in id_map.items():
                length = len(sub)
                if i + length > n:
                    continue
                if source[i:i + length] != sub:
                    continue
                tgt_sub = target[i:i + length]
                if tgt_sub not in id_map:
                    continue
                tid = id_map[tgt_sub]
                if dist[fid][tid] < INF:
                    dp[i + length] = min(dp[i + length], dp[i] + dist[fid][tid])
        return dp[n] if dp[n] < INF else -1
